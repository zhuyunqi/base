package com.zyq.library.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * 邮箱: zhuyunqi_88@163.com
 * 日期: 2016/11/15 16:24
 * 描述: RecyclerViewAdapter基类,支持RecyclerView
 *
 * @author zhuyunqi
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    protected Context context;
    private List<T> items;
    private int layoutId;
    protected OnItemClickListener mOnItemClickListener;

    public BaseRecyclerViewAdapter(Context context, List<T> items) {
        this(context, items, View.NO_ID);
    }

    public BaseRecyclerViewAdapter(Context context, List<T> items, int layoutId) {
        this.context = context;
        this.layoutId = layoutId;
        this.items = items != null ? items : new ArrayList<T>();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder holder = BaseViewHolder.createViewHolder(context, parent, layoutId);
        setListener(parent, holder, viewType);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        bindData(holder, items.get(position), layoutId);
    }

    @Override
    public int getItemViewType(int position) {
        layoutId = bindLayout(items.get(position));
        return layoutId;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public abstract int bindLayout(T item);

    public abstract void bindData(BaseViewHolder holder, T item, int layoutId);

    protected void setListener(final ViewGroup parent, final BaseViewHolder viewHolder, int viewType) {
        if (!isEnabled(viewType)) {
            return;
        }
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    mOnItemClickListener.onItemClick(v, viewHolder, position);
                }
            }
        });
    }


    /**
     * 添加数据
     *
     * @param item
     * @param position
     */
    public void addItem(T item, int position) {
        items.add(position, item);
        notifyItemInserted(position);
    }

    /**
     * 删除数据
     *
     * @param item
     */
    public void removeItem(T item) {
        int position = items.indexOf(item);
        items.remove(position);
        notifyItemRemoved(position);
    }

    protected boolean isEnabled(int viewType) {
        return true;
    }

    /**
     * 使用接口的方式实现ItemClick事件
     */
    public interface OnItemClickListener {
        void onItemClick(View view, RecyclerView.ViewHolder holder, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

}
