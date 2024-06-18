package com.indrajeet.chauhan.dittormapp.view.layoutmanager

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CircularLayoutManager(context: Context) : LinearLayoutManager(context, HORIZONTAL, false) {

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        val scrolled = super.scrollHorizontallyBy(dx, recycler, state)
        val parentWidth = width
        val childWidth = getChildAt(0)?.width ?: 0

        if (childWidth > 0) {
            if (dx > 0) {
                val firstVisibleItemPosition = findFirstVisibleItemPosition()
                val lastVisibleItemPosition = findLastVisibleItemPosition()
                if (lastVisibleItemPosition == itemCount - 1) {
                    scrollToPositionWithOffset(0, parentWidth - childWidth)
                }
            } else {
                val firstVisibleItemPosition = findFirstVisibleItemPosition()
                if (firstVisibleItemPosition == 0) {
                    scrollToPositionWithOffset(itemCount - 1, -parentWidth + childWidth)
                }
            }
        }
        return scrolled
    }
}
