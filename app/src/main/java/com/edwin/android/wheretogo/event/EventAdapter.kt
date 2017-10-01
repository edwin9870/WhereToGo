package com.edwin.android.wheretogo.event

import android.content.Context
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
class EventAdapter constructor(private val context: Context) : RecyclerView.Adapter<EventAdapter.EventAdapterViewHolder>() {

    private var events: MutableList<EventDTO>? = null

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
        picasso.load(event.backdropUrl).fit().centerCrop().into(holder.eventPosterImage)
    }

    class EventAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

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
        }

        override fun onClick(view: View?) {
            Logger.d("Card View clicked")
        }
    }

    fun setEvents(events: MutableList<EventDTO>) {
        this.events = events
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
}