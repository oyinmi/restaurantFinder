### Restaurant Finder
This is a sample android app to find the nearest restaurant based on the postcode provided


### Demo
https://github.com/user-attachments/assets/aa91ba23-1c0e-4704-aa09-102dce9f1210


### Assumptions
- App users will be using device with android version 14 and any newer version
- User will enter a valid UK postcode
- API response shape will not change
- API data points will always have data and in the right data type

### Improvements
- Adding UI and Unit tests
- Extract postcode validation inside viewmodel
- Implement a better postcode validation that will make sure the postcode actually exist
- Design a better UI and advance search methods
- Handle exception error from api call better
- Adding error monitoring mechanism for errors in the application
- Implementing default list of restaurant based on user's location
- Making the app accessible

### Features
- Search functionality by postcode
- View restaurant information
- List top 10 searched restaurant

### Methodology
- UI built with Jetpack Compose
- Architecture is based on MVVM approach
- API implementation is done using Retrofit

### How to Run
To run the application, follow the following
1. Clone the restaurant finder repository
    Clone the repository by running this command
    ```
    git clone git@github.com:oyinmi/restaurantFinder.git
    ```

2. Gradle Synchronisation
    - Open the cloned project using android studio software, make sure android sdk is setup properly
    - Sync the gradle by pressing the gradle button on the top right of android studio as seen in the picture below
    ![Screenshot 2025-04-02 at 16 33 28](https://github.com/user-attachments/assets/cb608f8a-b58d-4d5d-bddc-42389529a69d)

3. Running the app
    - Download and setup android virtual device which is used to create an emulator for running the app
    - Run the app by selecting the desired emulator and click on the run button as shown in the picture below
    ![Screenshot 2025-04-02 at 16 38 18](https://github.com/user-attachments/assets/b1594992-aac4-4203-ae73-ab87800bed9c)


