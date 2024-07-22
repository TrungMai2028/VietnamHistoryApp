package com.example.vietnam_history.data

import com.example.vietnam_history.R
import com.example.vietnam_history.model.Event

/**
 * [Datasource] generates a list of [Affirmation]
 */
class Datasource() {
    fun loadEvents(): List<Event> {
        return listOf<Event>(
            Event(R.string.event1, R.drawable.pic1, R.string.eventDescription1),
            Event(R.string.event2, R.drawable.pic2, R.string.eventDescription2),
            Event(R.string.event3, R.drawable.pic3, R.string.eventDescription3),
            Event(R.string.event4, R.drawable.pic4, R.string.eventDescription4),
            Event(R.string.event5, R.drawable.pic5, R.string.eventDescription5),
            Event(R.string.event6, R.drawable.pic6, R.string.eventDescription6),
            Event(R.string.event7, R.drawable.pic7, R.string.eventDescription7),
            Event(R.string.event8, R.drawable.pic8, R.string.eventDescription8),
            Event(R.string.event9, R.drawable.pic9, R.string.eventDescription9),
            Event(R.string.event10, R.drawable.pic10, R.string.eventDescription10),
            Event(R.string.event11, R.drawable.pic11, R.string.eventDescription11),
            Event(R.string.event12, R.drawable.pic12, R.string.eventDescription12),
            Event(R.string.event13, R.drawable.pic13, R.string.eventDescription13),
            Event(R.string.event14, R.drawable.pic14, R.string.eventDescription14),
            Event(R.string.event15, R.drawable.pic15, R.string.eventDescription15),
            Event(R.string.event16, R.drawable.pic16, R.string.eventDescription16),
            Event(R.string.event17, R.drawable.pic17, R.string.eventDescription17),
            Event(R.string.event18, R.drawable.pic18, R.string.eventDescription18),
            Event(R.string.event19, R.drawable.pic19, R.string.eventDescription19),
            Event(R.string.event20, R.drawable.pic20, R.string.eventDescription20),
            Event(R.string.event21, R.drawable.pic21, R.string.eventDescription21),
            Event(R.string.event22, R.drawable.pic22, R.string.eventDescription22),
            Event(R.string.event23, R.drawable.pic23, R.string.eventDescription23),
            Event(R.string.event24, R.drawable.pic24, R.string.eventDescription24),
            Event(R.string.event25, R.drawable.pic25, R.string.eventDescription25),
            Event(R.string.event26, R.drawable.pic26, R.string.eventDescription26),
            Event(R.string.event27, R.drawable.pic27, R.string.eventDescription27),
            Event(R.string.event28, R.drawable.pic28, R.string.eventDescription28),
            Event(R.string.event29, R.drawable.pic29, R.string.eventDescription29),
            Event(R.string.event30, R.drawable.pic30, R.string.eventDescription30)


        )
    }
}
