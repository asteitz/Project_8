# Project_08 - Movie Search App
<span style="font-size: smaller;"><strong>Ashley Steitz and Jacob Fritz worked on this as partners</strong></span>

---
<span style="font-size: smaller;"><strong> Description </strong> </span>
In our Project 8 we called the IMDB API to search for Movies and retrieve the data (if there is any), then populates an XML file. We also allow the user to share the icon, visit the IMDP page themselves, and send us feedback.
<br>

This app allows for a user to:
- Search for a movie
- See the stats (rating, ranking, runtime, etc)
- Share a link
- Visit the IMDB page via link

To begin we integrated an API call to the IMDB page in order to request information on a Movie. If the request
was valid, we parsed the data from the JSON file and displayed the values in an XML file. Through this process we 
allowed the user to share this data or click the link to take them to the IMDB page.
<br>
<br>
When taken to the main page, you are able to enter a movie title, upon hitting search the app takes you to a page that 
holds the information, the poster, and the ability to share the movie. Additionally, if you feel you can also submit feedback by pressing
the button up in the ribbon where you will be taken to Gmail or any other messaging platform you have installed on your emulator.
<br>
<br>
In the case that you submit an invalid movie title, the contents will not populate and you will be told that the IMDB page does not support that movie.




## Functionality
'*' indicates tested in GIF  
The following **required** functionality is completed:
<br>
**Demonstrated**
<br>
**START**
* [SEARCH] [Titanic] -> [EVERYTHING WAS POPULATED] -> [Clicked Share and the options came up] -> [Link was followed to IMDB page] -> [SEND FEEBACK was pressed] -> [Opened GMAIL and sent off a message] -> [Great work! sent to jamfritz@iu.edu] -> [Brought back to movie screen] -> [back to main screen]
* [SEARCH] [Parent Trap] -> [No photo for this movie] -> [All stats came up] -> [back to main page]
* [SEARCH] [Pulp Fiction] -> [ALL ITEMS CAME UP]
<br>

**END**


---
## Video Walkthrough
Watch a demonstration of the different options when working with the notes app in the gif available on Github
Here's a walkthrough of a few translations:
<br>
![Recording in GIF of Walk Through](https://github.com/asteitz/Project_8/blob/master/app/src/main/java/com/example/project8/Project8Video.gif)

GIF created with [CloudConvert](https://cloudconvert.com/).

UI Challenges:
- Connecting the link as clickable passing the data in from the JSON file and handling it correctly
- UI was relatively simple so not many errors followed

Backend Challenges:
- Calling the API point
- Data Binding stopped working when we attempted the recycler view
- Working with the format through indexing was more of a learning curve but easy once we got it down

## License

    Copyright [2023] [Ashley Steitz, Jacob Fritz]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
