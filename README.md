docs link: https://docs.google.com/document/d/1aooGSe6HtAYIrTDZtrHYw_hWCvL-XjSpZPgg5QQzS5c/edit

HealthHelp App Requirements Specification
Version: 1.1
By: Michael Mellone, Elise Prete, GiGi Katuala, Cindy Zhang
Date: 2/25/2020





Table of Contents
Introduction	2
Document Conventions	3
Non-Functional Requirements	4
Functional Requirements	5
UI layout	11
References	14

Revision History
Date
Version
Changes Made
2/13/2020
1.0
Initial Requirements Specification document
2/25/2020
1.1
Updated to reflect feedback and improve traceability paired with Project Plan document

HealthHelp App Details
Introduction 
Our final product for this project will be a simple and convenient personal health monitoring and tracking application that will be available on Android mobile device platforms. This application will be marketed towards users who are health conscious and whose goals include becoming more informed and aware of their personal health patterns and improving their personal health and fitness. Through our application, users will be able to create a profile with personal information,with a username and password log-in that will secure their data, and input their health-related goals, such as diet, weight, and hours of sleep, and alter them as necessary. In addition, users will be able to regularly input in their progress towards their goals and track their historical progress and patterns in an easy to understand chart of their results. 

Document Conventions
Android: Mobile operating system based on modified Linux kernel and other open source software 
Application: Computer software package that performs a specific function directly for an end user or another application
FireBase: Web application made by Google that is used for many aspects in app development such as databases, authentication, storage, etc

React: JavaScript library for building user interfaces
Python: Interpreted, high-level, general-purpose programming language 
UI: (User interface ) the means of the user interacting and controlling the application  

Non-Functional Requirements
1. Run on Android - Android app made using Android Studio
2. Database (Google FireBase) - used to store the user login information as well as information they had input initially.  Stores new data that a user will input to update their goals that they have set.  Functions such as the trackers and updaters will be able to access this data to provide the user with a detailed look at how much they are improving over the course of using the app.
3. System Architecture 
The frontend is a React application for Android. 
User first interacts with the login page.  After the user enters their information it goes through the authentication.  If authentication succeeds it brings the user to the main page.  If authentication fails it brings the user back to the login page with an error message.
From the main page the user can access other pages such as their goals page, profile page, etc.
The backend will be in Python and will be connected to a database to store the user data. 
4. Constraints
Can't set a weight goal without knowing current weight. 
Can't track the type of sleep the user was in throughout the night (i.e. REM sleep, light sleep, deep sleep).
Can't give tips/progress for goals if there is no information included in one section of the app (i.e. if the user chooses to not log their calories for the day or set a daily calorie goal and chooses to not log their weight, the app cannot prove helpful tips on how to reduce calories/lose weight).
Progress can only be tracked provided that the user enters his or her steps, calories, and weight.
Differences in coding language background among team members. 

Functional Requirements
5. New User Creates Profile
Function: Create profile if new user option is selected on opening app page 
Description: Redirects users to Create Profile page if they select new user option on the opening page. Enables users to create username and password to log in with. Enables users to input basic information such as height, weight, gender, and age. Username, password, first name, and last name should be required, but users can select whether or not they want to input height, weight, gender and/or age. 
Input: Username and password of user. Basic information about users. 
Source: User input into form 
Output: Basic Profile of user that includes basic information. Log-in Information that is used to secure user data
Destination: Login information stored for future authentication. Basic Profile information stored and displayed on screen when user returns. 
6. New User Input Goals
Function: Input initial goals in page for new users right after they have completed Create Profile form
Description: Directs users to Input Goals page after they have completed the Create Profile form. Enables users to select from a list of goals as well as input in their own goals in an Other option. Enables users, for each goal, to input current value of goal (ex: current weight), desired value of goal, and possible time frame to achieve goal. Users can select if they would like to input their heights in feets/inches or in centimeters, Users can also select if they would like to input their weight in pounds or kilograms. 
Input: User selected goals, user inputted current value of goal, user inputted desired value of goal. Possibly user inputted time frame to achieve the goal. 
Source: User input form 
Output: User’s goal list 
Destination: Display on screen under Basic Profile when user returns. 
7. Returning User Authentication Succeeds 
Function: Directs authenticated user to home/general information page 
Description: If returning user authentication is successful, redirects users to the home page where they can view their Profile Section, Goals Section, and Weekly Summary. 
Input: User input username and password when opening app 
Source: User input form appears on screen when opening the app
Output: Home Page of user when authentication succeeds
Destination: Display Screen 
8. Returning User Authentication Fails
Function: Displays error message on login screen when user authentication fails
Description: If returning user authentication fails, redirects user back to login screen with error message displayed on it. 
Input: User input username and password when opening app 
Source: User input form appears on screen when opening the app 
Output: Login Page with error when authentication fails 
Destination: Display Screen. 
9. Returning User Changing Goals
Function: Edit or change a specific goal that a returning user had set previously.
Description:  Allows the user to edit or change a goal that they had previously set as well as allowing them to set new goals.
Input: Selected goal, current goal value, desired goal value.
Source: User input form
Output: Updated list of the users goals.
Destination: Display screen
10. Updating Goals
Function: Show the user of progress on their goals.
Description: Periodically updates the progress on goals via input by the user, and allows them to view their progress on how far away they are from reaching the goal that was set.
Input: Value associated with the specific goal that the user wants to update and keep track of. 
Source: The initial goal values that the user has set and the update value that they input for the specified goal.
Output: Updated goal values that tell the user how far away they are from reaching the goal that they set.
Destination: Display screen
11. Activity Tracking 
Function: Tracks the users activity by allowing the user to input their activity level on a daily basis.
Description: Allows the user to input information on their activity level such as, steps taken, miles run, or workouts completed.  Users will be able to input this information on a daily basis and it will log the information so the user can reference it at a later time.
Input: Steps taken, miles run, workouts done.
Source: A prompt that allows the user to enter this information.
Output: Activity for the current day, as well as their activity on previous days.
Destination: Display Screen
12. Training Progress
Function: Tracks the user’s progress in the gym if they frequently lift weights.
Description:  Allows users who frequently lift weights to keep track of their progress in the gym.  This allows them to input an exercise, a description of the exercise, whether it was a dumbbell, barbell, body weight, or machine exercise, how much weight they lifted (if applicable), how many reps the did, and how many sets they did.
Input: User will input the exercise they want to track and choose from 4 options; Dumbbell, Barbell, Machine, or Body Weight, with the ability to add an optional description of the exercise.  They will be able to put the amount of sets they did and how many reps in each set. Additionally if it was a weighted exercise they can input the amount of weight they had lifted.
Source: Input from the Training Progress form.
Output: A detailed breakdown of the exercise showing the user the amount of sets, reps, and weights they had lifted for that particular exercise on that day.
Destination: Display Screen
13. Home Page 
Function: Displays basic information from user profile, user’s weekly statistics, and goals
Description: Displays information from Create Profile page input by user and contains links to pages with goals set by user for different aspects of health
Input: Basic information about user, goals of user
Source: User input from form
Output: Profile information of user
Destination: Display screen
14. Profile Page
Function: Display Profile Section, Goals Section, and Weekly Summary
Description: The links to different aspects of the user’s health are split between three pages; the profile section with their basic health information, the goals they set when they created their profile, and the progress they have made towards the goals they have set
Input: User authentication 
Source: Create Profile page
Output: Profile of user
Destination: Display screen
15. “Healthful” Tips
Function: Inform user of different ways to maintain and improve health 
Description: As the user starts working towards goals set, general tips pertaining to the aspect of their health that the goal addresses appear on the screen
Input: User goals, general information for maintaining health
Source: Research done by developers 
Output: Information for how to achieve specific goals set
Destination: Display screen
16. Weekly/Monthly Check In and Progress
Function: Keep track of each aspect of user health from week to week, or month to month
Description: User enters new information whenever there is a change in their health
Input: User’s most current health statistics
Source: Update Profile page
Output: Updated user profile
Destination: Display screen

UI layout
17. Login page:

The user is prompted with sign in information and given an option to create an account if they do not already have one.  When clicking sign up/create an account, they will be directed to another page to enter their name and other health related information to build a profile.  Once the profile is built they will be directed to the home page.




18. Sign-up Page:

If the user is new to the app, they will be brought to this page to enter information to build their profile.  They will enter their first and  name as well as  height, age, and weight if they want, but only their name, username, and password is required.  They will also enter a username and password that they will use to log into the app if they log out of the app at any point.  These will then be stored as the starting values for each category and used as needed for other functions of the app.  For example, height and weight will be used to calculate BMI.  When the users weight changes, so will their BMI.  Thus, this new value is stored as their current BMI and can be used to check against past BMI values or their BMI goal.  When looking for a user in the database, the last name is searched for.  If multiple people have the same last name, then the first name is searched for.  A cancel button is also included in case a user accidentally clicked sign up or they don't want to sign up anymore.

19. Home Page:

The homepage will include the user’s current day’s information such as steps, weight, height, calories, hours of sleep, and BMI.  These will be buttons that when clicked on,  the user will be directed to a page that is specific to that category (i.e. if the user clicks on steps, he or she will have the option to see their history of steps and step goals).  The user then has the option to see all of their weekly/monthly progress as well.  This page will  also include a logout button for the user to have the option to sign out of their account if they desire.  This page also includes a button to allow the user to delete their account and the user’s account is erased from the database.


Workflow: 


References
FireBase: https://firebase.google.com/
React: https://reactjs.org/
Python: https://www.python.org/
UI: https://techterms.com/definition/user_interface 
Android: https://techterms.com/definition/android
Application: https://techterms.com/definition/application




Requirement Document Work Split 
Name
Contribution 
Cindy 
Introduction, Functional Requirements (New User Creates Profile, New User Creates Goals, Returning User Authentication Fails/Succeeds)
Non-Functional: System Architecture 
Elise 
Constraints, UI layout (login page, sign up page, home page)
Michael 
Functional Requirements: Returning User Changing Goals, Training Progress, Activity Tracking, Updating Goals
Non-Functional: Database, System Architecture
GiGi
App Name, Document Conventions, Functional Requirements: Home Page, Profile Page, “Healthful” Tips, Weekly/Monthly Check In and Progress


