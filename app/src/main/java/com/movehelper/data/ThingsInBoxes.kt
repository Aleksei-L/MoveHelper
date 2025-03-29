package com.movehelper.data

import androidx.room.Embedded
import androidx.room.Relation

data class ThingsInBoxes(
	@Embedded val box: Box,
	@Relation(
		parentColumn = "id",
		entityColumn = "boxId"
	)
	val things: List<Thing>
)
