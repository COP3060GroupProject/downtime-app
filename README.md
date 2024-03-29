README 
===

# DOWNTIME

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
1. [Schema](#Schema)

## Overview
### Description
This app will be geared towards students. It will allow users to sync their phone’s calendar, add events/tasks within the app, and input their class schedules with the purpose of showing them the chunks of free time they will have during the day. 

### App Evaluation
- **Category:** Productivity
- **Mobile:** This app’s functionality would be limited to mobile only. This is because we want to encompass the “on the go” lifestyle. 
- **Story:** Analyzes users tasks for the day and tells users the time periods during the day when they will have downtime (time they can use to be productive or do leisurely activities).
- **Market:** Mainly marketed towards high school and college students.
- **Habit:** This app should be used daily for help with increased productivity.
- **Scope:** First we would start with marketing to college students and would want to expand to being a productivity app for all. We would also want to expand into the health arena as well by tracking sleep and eating habits within the app as well.

## Product Spec
### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User logs in to access calendar and preference settings
* User can add a task or event to their calendar
* User can input their class schedule (name, credit hours, class time)
* User can see their free blocks of time in pie chart form (possibly get an alert when a chunk of free time is starting)
* User can time how long it takes for them to complete a certain task
* Profile pages for each user
* Settings (Accessibility, Notification, General, etc.)

**Optional Nice-to-have Stories**

* Being able to sync calendars with other users
* Machine learning to see how long it takes a user to typically complete a certain task
* Recommending an order of completing tasks based on the priority of tasks for the week
* Recommending to a user when they should start getting ready for bed

### 2. Screen Archetypes

* Login/Register - User logs into their account or signs up 
   * Upon download/reopening of the application, the user is prompted to log in to gain access to their profile or they can create an account.
* Daily Calendar Screen - Shows users their daily events/tasks
   * After logging in, this is the first screen users will see. It will default to a daily calendar view but they can choose a weekly or monthly view.
* Slack Time Screen - Shows users a graphical view of how their time for the day is being used
   * After tapping the corresponding icon in the menu bar, users will see a pie chart depicting all their tasks for the day. This screen will also recommend how many hours of sleep the user should plan to add into their day.
* Add task/Add Event Screen
   * After tapping the corresponding icon in the menu bar, users will be able to either add an event or add a task to their calendar within the app.
* Task Timer Screen
   * After tapping the corresponding icon in the menu bar, users will be able to either pull an existing task from their calendar or add a task with which they can set a timer to see how long it takes them to complete it. This will help with calculating how much free time the user really will have during their day.
* Profile Screen 
   * Allows user to upload a photo, edit their class schedule, and insert school information.
* Settings Screen
   * Lets users sync their calendar, and edit their app notification settings.

### 3. Navigation
  
**Tab Navigation** (Tab to Screen)

* Calendar
* Add Event/Add Task
* Slack Time
* Task Timer
* Profile
* Settings

**Flow Navigation** (Screen to Screen)
* Forced Login -> Account creation if no login is available
* Calendar -> Shows a daily view
* Add Event/Add Task -> Buttons to add event/task to calendar
* Slack Time -> Shows chart and description of free time
* Task Timer -> Text field, timer
* Profile -> Text field to be modified
* Settings -> Toggle settings

## Wireframes
<img src="https://i.imgur.com/EEVKjBQ.jpg" width=800><br>

### [BONUS] Digital Wireframes & Mockups
|Sign-up|Log In|Main|Create|Leisure Time|
|---|---|---|---|---|
<img src="https://github.com/COP3060GroupProject/downtime-app/blob/master/signup.PNG" width=200><br> |<img scr="https://github.com/COP3060GroupProject/downtime-app/blob/master/login-in.PNG" width=200><br>|<img src="https://github.com/COP3060GroupProject/downtime-app/blob/master/main2.PNG" width=200><br>  |<img src="https://github.com/COP3060GroupProject/downtime-app/blob/master/create.PNG" width=200><br> | <img src="https://github.com/COP3060GroupProject/downtime-app/blob/master/leisure2.PNG" width=200><br>|

### [BONUS] Interactive Prototype

## Schema 
### Models
#### User

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | userId        | String   | unique id for the user login (default field) |
   | email         | String   | user verification|
   | password      | String   | user inputs password at login |
   | createDate    | Number   | date when account was created |
   | Updatedate    | Number   | date when account was last updated|
   
   #### Calendar

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | day           | DateTime | input day of task |
   | month         | DateTime | input month of task |
   | year          | DateTime | input year of task |
   | taskId        | number   | unique id for the task |
   | timeStart     | Number   | start time for task |
   | timeEnd       | Number   | end of task time |
   | priority      | number   | task rank from 1-5 |
   | taskName      | String   | name of task  |
   
   #### New Task
   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | day           | DateTime | input day of task |
   | month         | DateTime | input month of task |
   | year          | DateTime | input year of task |
   | taskId        | number   | unique id for the task |
   | timeStart     | Number   | start time for task |
   | timeEnd       | Number   | end of task time |
   | priority      | number   | task rank from 1-5 |
   | taskName      | String   | name of task  |
   
   #### Timer

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | hours         | number   | hour when the user starts the timer |
   | minutes       | number   | minute when the user starts the timer |
   | seconds       | number   | seconds when the user starts the timer|
   | taskId        | String   | unique id for the user post |
  
   #### User Profile

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | userID        | String   | unique id for the user|
   | school        | String| Users name of school |
   | className     | String  | users class name|
   | meetingDay    | String | day when the class takes place|
   | ClassTimeStart | Number   | time when the class starts|
   | ClassTimeEnd   | Number   | time when the class ends |
   | ClassWeight   | Number | measure of the class weight|
   
   ### Networking
#### List of network requests by screen
   - User Login Screen
      - (Read/POST) Read user's password 
      - (Create/POST) Create a new user
      
   -New Task Sceen
      - (Create/POST) Create a new task
    
   - User Profile Screen 
      - (Update/Put) Update user profile information
      - (Read/Get) Query logged in user
      
   - Daily Task (Calendar) Screen
      - (Read/GET) View all tasks
      - (Update/PUT) Manage the list of task
      - (Create/Post) Create a new task
      - (Delete) Delete a task from the calendar
      
   - Slack Time Screen
      - (Read/Get) View data of estimated slack/leisure time
      
   - Settings Screen
      - (Update/Put) change/modify application settings
      - (Read/Get) View current application settings
   
