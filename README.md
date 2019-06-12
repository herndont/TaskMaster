# TaskMaster

###Lab36

    Featured Tasks
        - Users should be able to see Tasks displayed in a RecyclerView with an appropriate ViewAdapter.
        - Users should be able to tap on one Task to view an activity with detailed information about that task.
        - Users should be able to create a Task. Tasks have a title, a description, and a state.
        - Task data should be persisted with Cloud Firestore.
        - The ViewAdapter should be well-tested.
      A task should have one property which represents what state the task is in.
        - Available - the task has been created, and is publicly available, but no other user has claimed it yet
        - Assigned - someone has been assigned that task
        - Accepted - the assignee has accepted that task
        - Finished - the task is totally complete Write tests making sure a task progresses through its states properly.
            
            
![main page](/app/src/main/res/drawable/mainLogin.PNG)
![Task Entry](/app/src/main/res/drawable/taskEntry.PNG)
        
###Lab37

    Featured Tasks
        - User should be able to log in.
            - At a minimum, they should be able to log in with email and password.
        - Users should be able to see all the Tasks in a cloud database.
        - A user should be able to "Assign" a task to themself.
        - The user assigned to a task should be able to "Accept" that task, and later "Complete that task.
        
**************** Screenshots to come for Lab37 (Nothing to show currently) ****************


###Lab38

    Featured Tasks
        - A user should be able to visit a "My Tasks" screen.
        - On that screen, they should be able to see all tasks currently assigned to them, and 
          progress their states.
            - Those tasks should be displayed in a RecyclerView and should use the same ViewAdapter
              class as the main activity.
        - A user shouold be able to filter their "My Tasks" screen into "open" tasks (assigned/accepted)
          or "all" tasks (accepted/accepted/finished).
        - Your ViewAdapter should still be well-tested for this use case.
        
**************** Screenshots to come for Lab38 *********************


###Lab39

    Featured Tasks
        - A user should be able to visit a "My Profile" screen.
        - On that screen, they should be able to view and edit their username and a bio
        - On the Task detail screen, tapping on an assigned user should display that user's profile.
   
        
###Lab41

    Featured Tasks
        - User's device tokens should be saved in their user profile.
            - If a user logs in from multiple devices, all their device tokens should be saved to their profile.
        -You should be able to use the notifications composer to send a notofication to all devices with your app on them.
        
*************** Screenshots to come for Lab41 user interface and database structure****************

     Progress today:
        -Fixed the audio pulling issue
        -Got things back into the database, but will need to continue working on that. 
        -Fixed the logout button
        
        -Will continue to play catch up this evening and work on resubmits for the previous labs as well as getting caught up to present spot in labs.
        
###Lab42

    Featured Tasks
        - When a task's state is updated, everyone who has ever interacted with that task (creator or assignee) should get a notificaiton about the update.
            - The notification should include the task title and the state.
            - Tapping the notification should take the user to the detail page about that task within the app.
            
************ Screenshots of completed work to come in resubmit and database structuring ***********

###Lab43

    Featured Tasks
        - Any iconography in your app should be well-labeled with a contentDescription.
        - Use the hint attribute on all editable elements in your app, or labelFor to allow a TextView to serve as a label.
        - Use the focusable attribute to show that a particular ViewGroup consists of one piece of data.
        
************ Screenshots of completed work to come in resubmit and database structuring ***********
        
