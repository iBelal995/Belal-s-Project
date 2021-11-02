# TODL-Project
### Description : 
It's a well-organized To Do List application on the Android Studio that helps you manage your daily tasks and lets you make changes simply, such as adding, editing, and removing tasks, among other things!

### ![Mask Group (1)](https://user-images.githubusercontent.com/91452283/139941414-6e3c6689-e7e5-4af3-a6ed-8d4ab972ad90.png)


### Technologies used
- [Kotlin](https://developer.android.com/kotlin)
- [android studio](https://developer.android.com/studio?gclid=Cj0KCQjww4OMBhCUARIsAILndv7dnvotv1KjpsvyCGg74yWzg7zXsTLeEz078nbHA6wWZbaUZSUWlGgaAuMNEALw_wcB&gclsrc=aw.ds)
- [Matirial design](https://material.io/components?platform=android)
- [Figma](https://www.figma.com/)

### Libraries Used
- [Architecture][1] - A collection of libraries that help you design robust, testable, and
  maintainable apps. Start with classes for managing your UI component lifecycle and handling data
  persistence.
 - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Architecture Components provides ViewModel helper class for the UI controller that is responsible for preparing data for the UI,ViewModel objects are automatically retained during configuration changes so that data they hold is immediately available to the next activity or fragment 
* [Data Binding][2] - Declaratively bind observable data to UI elements.
* [Lifecycles][3] - Create a UI that automatically responds to lifecycle events.
* [LiveData][4] - Build data objects that notify views when the underlying database changes.
* [Navigation][5] - Handle everything needed for in-app navigation.
* [Room Database][6] - Access your app's SQLite database with in-app objects and compile-time checks.
* [ViewModel][7] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
     asynchronous tasks for optimal execution.
* [UI][9] - Details on why and how to use UI Components in your apps - together or separate
  * [Animations & Transitions][10] - Move widgets and transition between screens.
  * [Fragment][11] - A basic unit of composable UI.
  * [Layout][12] - Lay out widgets using different algorithms.
* Third party and miscellaneous libraries
  * [Glide][14] - for image loading
  
  


[0]: https://developer.android.com/jetpack/components
[1]: https://developer.android.com/jetpack/arch/
[2]: https://developer.android.com/topic/libraries/data-binding/
[3]: https://developer.android.com/topic/libraries/architecture/lifecycle
[4]: https://developer.android.com/topic/libraries/architecture/livedata
[5]: https://developer.android.com/topic/libraries/architecture/navigation/
[6]: https://developer.android.com/topic/libraries/architecture/room
[7]: https://developer.android.com/topic/libraries/architecture/viewmodel
[8]: https://developer.android.com/topic/libraries/architecture/workmanager
[9]: https://developer.android.com/guide/topics/ui
[10]: https://developer.android.com/training/animation/
[11]: https://developer.android.com/guide/components/fragments
[12]: https://developer.android.com/guide/topics/ui/declaring-layout
[14]: https://bumptech.github.io/glide/



### Screenshots Android Studio

 Add ToDo | 
 --- | 
![add](https://user-images.githubusercontent.com/91452283/139950312-bc88c6d8-fba4-47da-aa41-2e88903cc395.jpg)
 Edit title ToDo |
  ![image](https://user-images.githubusercontent.com/91452283/139950469-15edd630-9949-4209-86c2-b2dbb588e2e8.png)
 Edit task description ToDo |
 ![image](https://user-images.githubusercontent.com/91452283/139950831-85a0cb6d-7130-41cc-b3c1-e8f07208e933.png)
 Delete ToDo |
 ![image](https://user-images.githubusercontent.com/91452283/139951626-b777717b-6f28-4ed0-b72c-1885779ad218.png)
 Check ToDo |
 ![image](https://user-images.githubusercontent.com/91452283/139951690-7ac32332-8160-40ce-b8bb-41bbd208e0c9.png)
### Screenshots Figma
![image](https://user-images.githubusercontent.com/91452283/139952146-59f9251e-ee92-44c7-816d-61f51b0c047b.png)

### Favoraite Features 
- Adding tasks - You can add as many tasks as you want.
- Creation date - When you create a task, the app will automatically post the date when it was created.
- Task deletion - You can delete any task, whether it's a primary task or a subtask.
- Editing tasks - Using the update feature, you may change the task title and description.
- Neasted tasks - Within the primary task, you can add subtasks.
- Due date - For each task available, you may add a due date (deadline) to ensure that the task is completed within a certain amount of time. 
- complete check - you can check box any task you added whether it's overdue or not
- indicators of the status - there is an indicators for each task added of three indicators : in progress, completed, overdue
- priority - When you create a task, you can set the task's priority using three indicators: High, Medium, and Low
- Sort by alphabet A-Z - With a press of a button, you may sort the tasks by letter A-Z order.



### Upcoming features
- Firebase
- Enable filtering
- Enforce due dates notifcation
- Geofencing

