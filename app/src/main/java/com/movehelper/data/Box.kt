package com.movehelper.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Box(
	@PrimaryKey val id: String,
	val name: String,
	//TODO val things: List<Thing>
)
