# FRND - Assignment

This is a repository that contains Android assignment of FRND. 

### ![Download APK](https://github.com/Kingbond470/Android-Practice/blob/main/FRND%20IMAGE/app-debug.apk) 

## Getting the sample code

Get the latest sample code from GitHub using Git or download the repository as a ZIP file. 

      git clone https://github.com/Kingbond470/FRND_TASK.git

### Sample Image

<table>
  <tr>
    <td>Home</td>
    <td>Create Task</td>
   <td>Show Task</td>
  </tr>
  <tr>
    <td><img src="https://github.com/Kingbond470/Android-Practice/blob/main/FRND%20IMAGE/Home.jpg" width="280"/></td>
    <td><img src="https://github.com/Kingbond470/Android-Practice/blob/main/FRND%20IMAGE/Calendar.jpg" width="280"/></td>
    <td><img src="https://github.com/Kingbond470/Android-Practice/blob/main/FRND%20IMAGE/showtask.jpg" width="280"/></td>
  </tr>
 </table>
 
 
## Architecture

This app uses [MVVM (Model View View-Model)](https://developer.android.com/jetpack/guide#recommended-app-arch) architecture.

<img src="https://camo.githubusercontent.com/be9b0e8eb62e13a031031fb16e99f33c647da47908a21f451cb00d2c99fb9b31/68747470733a2f2f646576656c6f7065722e616e64726f69642e636f6d2f746f7069632f6c69627261726965732f6172636869746563747572652f696d616765732f66696e616c2d6172636869746563747572652e706e67">

### The app has following packages:

    data: It contains all the data accessing and manipulating components.
    di: Dependency providing - Hilt.
    repository: Collect data from different data sources(APIs, local database storage) and provides data to the rest of the app
    ui: View classes 
    utils: Utility classes.
    viewmodel: retrieves the necessary data from the repository, responsible for preparing and managing the data
  
    Note : Classes have been designed in such a way that it could be inherited and maximize the code reuse

### Using Jetpack Architecture Components

    LiveData
    ViewModel
    
### Library reference resources:

• Room: https://developer.android.com/topic/libraries/architecture/room.html

• ViewModel: https://developer.android.com/topic/libraries/architecture/viewmodel

• LiveData: https://developer.android.com/topic/libraries/architecture/livedata

• Buttons: Floating Action Button: https://material.io/components/buttons-floating-action-button/android

• Parallax: https://developer.android.com/reference/androidx/leanback/widget/Parallax

• DrawerLayout: https://developer.android.com/reference/androidx/drawerlayout/widget/DrawerLayout
    

    

