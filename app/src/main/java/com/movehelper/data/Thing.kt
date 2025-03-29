package com.movehelper.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
	foreignKeys = [ForeignKey(
		entity = Box::class,
		parentColumns = ["id"],
		childColumns = ["boxId"],
		onDelete = ForeignKey.SET_NULL
	)]
)
data class Thing(
	@PrimaryKey val id: Int,
	val name: String,
	val description: String?,
	val boxId: Int?
)
