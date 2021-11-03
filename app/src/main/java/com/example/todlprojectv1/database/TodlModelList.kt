package com.example.todlprojectv1.database

import androidx.room.*
/*** You define each Room entity as a class that is annotated with @Entity.
A Room entity includes fields for each column in the corresponding table in the database,
including one or more columns that comprise the primary key.
 **/

/***
 * The following code defines a ItemModel data entity type relation one - many.
 * Define one-to-many relationships
A one-to-many relationship between two entities is a relationship where each instance of the parent
entity corresponds to zero or more instances of the child entity,
but each instance of the child entity can only correspond to exactly one instance of the parent entity.
 * Each instance of ItemModel represents a row in a ItemModel table in the app's database.
 * */
@Entity
data class TodlModelList(
    var taskTitle:String,
    val priority: String,
    var dueDate: String,
    var creationDate: Long,
    var completed: Boolean,
    @PrimaryKey(autoGenerate = true)
    val taskId: Int =0)
    @Entity(
        /**@ForeignKey is used to enforce relational structure when INSERTING / MODYFING your data.
         * A @ForeignKey defines a constraint (aka rule) that requires that the child column(s) exist in the parent column(s).
          If an attempt is made to break that rule then a conflict occurs (which may be handled various ways by the onDelete/onUpdate definition).
         */
        foreignKeys = [ForeignKey(
    entity = TodlModelList::class,
    parentColumns = arrayOf("taskId"),
    childColumns = arrayOf("mainTaskId"),
    onDelete = ForeignKey.CASCADE
)]
)
    data class TodlModelSubList(
    val subTask:String,
    val prioritysub:String,
    var description:String,
    @ColumnInfo(index= true)
    val mainTaskId: Int,
    @PrimaryKey(autoGenerate = true)
    val subTaskId: Int = 0

)
/**@Relation is used to enforce relational structure when RETRIEVING / VIEWING your data.
 * @Relation automatically (effectively) joins the tables and generates the number of child objects.
 *  @Relation annotation to the instance of the child entity,
 *  with parentColumn set to the name of the primary key column of the parent entity and entityColumn set to the name of the column of the child entity that references the parent entity's primary key.
*/
data class MainTaskWithSubTask(
    @Embedded val task: TodlModelList,
    @Relation(
        parentColumn = "taskId",
        entityColumn = "mainTaskId"
    )
    val subTask: List<TodlModelSubList>
)


