package com.edwin.android.wheretogo.event

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.edwin.android.wheretogo.R
import com.edwin.android.wheretogo.models.dto.EventDTO
import com.orhanobut.logger.Logger
import com.squareup.picasso.Picasso
import android.util.DisplayMetrics
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
class EventAdapter constructor(private val context: Context, private val eventListener: EventListener) : RecyclerView.Adapter<EventAdapter.EventAdapterViewHolder>() {

    var events: MutableList<EventDTO>? = null

    companion object {
        const val HEART_COLOR = "#98002e"
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup?, viewType: Int): EventAdapterViewHolder {
        val viewGroupContext = viewGroup?.context
        val inflater: LayoutInflater = LayoutInflater.from(viewGroupContext)

        val view: View = inflater.inflate(R.layout.item_event, viewGroup, false)
        return EventAdapterViewHolder(view)
    }

    override fun getItemCount(): Int = when(events) {
        null -> 0
        else -> events!!.size
    }

    override fun onBindViewHolder(holder: EventAdapterViewHolder, position: Int) {
        Logger.d("event: $events[$position], position: $position")

        val event = events!![position]
        holder.eventTitle.text = event.title
        holder.placeName.text = event.place
        holder.eventDate.text = Date(event.eventDateTime).toDate()
        holder.eventTime.text = Date(event.eventDateTime).toTime()

        val picasso = Picasso.with(context)

        when (event.backdropUrl) {
            null -> picasso.load(R.drawable.ic_no_event).fit().centerCrop().into(holder.eventPosterImage)
            else -> picasso.load(event.backdropUrl).fit().centerCrop().into(holder.eventPosterImage)
        }

        if(event.isFavorite) {
            holder.heartImage.setBackgroundColor(HEART_COLOR)
        }
    }

    inner class EventAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var eventTitle: TextView
        var placeName: TextView
        var heartImage: ImageView
        var eventPosterImage: ImageView
        var eventDate: TextView
        var eventTime: TextView

        init {
            itemView.setOnClickListener(this)
            eventTitle = itemView.findViewById(R.id.text_event_title)
            placeName = itemView.findViewById(R.id.text_place_name)
            heartImage = itemView.findViewById(R.id.image_heart)
            eventPosterImage = itemView.findViewById(R.id.image_event_poster)
            eventDate = itemView.findViewById(R.id.text_event_date)
            eventTime = itemView.findViewById(R.id.text_event_time)

            heartImage.setOnClickListener {
                eventListener.onclickHeart(events!![adapterPosition], it)
                when (events!![adapterPosition].isFavorite) {
                    true -> {
                        (it as ImageView).alpha = 1f
                        it.setBackgroundColor(HEART_COLOR)
                    }
                    false -> {
                        (it as ImageView).alpha = 0.7f
                        it.setColorFilter(R.color.default_heart_color)
                    }
                }
            }
        }

        override fun onClick(view: View?) {
            Logger.d("Card View clicked")

        }
    }

    fun addEvents(events: MutableList<EventDTO>) {
        when(this.events) {
            null -> this.events = events
            else -> this.events!!.addAll(events)
        }
        Logger.d("New events added")
        notifyDataSetChanged()
    }

    private fun Date.toDate() : String {
        val df = SimpleDateFormat(context.getString(R.string.date_format), Locale.US)
        return df.format(this)
    }

    private fun Date.toTime() : String {
        val df = SimpleDateFormat(context.getString(R.string.time_format), Locale.US)
        return df.format(this)
    }

    fun View.setBackgroundColor(color: String) {
        if(this is ImageView) {
            this.setColorFilter(Color.parseColor(color))
        }else {
            this.setBackgroundColor(Color.parseColor(color))
        }
    }


    interface EventListener {
        fun onclickHeart(event: EventDTO, view: View)
    }
}