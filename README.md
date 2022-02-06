# MeisterLabsPractical
My Practical for Meisterlabs
DONE 

The endpoint is:
https://www.meistertask.com/search?filter={"text":"query"}&response_format=object
You have to add these headers to the POST request:
Accept
application/json


DONE : (Stored in SharedPreferences)
Authorization
Bearer 2N6edq_uS3ACq89RhzN2yQtdT5aEhbKgaE5-P9BD3hc


DONE : Searching is done on the basis od text. However, I could not perform search by passing status value.
● After the startup the filter is set to “All”. When another filter is clicked, the search is done
again and the filter button is selected. Only one filter can be selected at once.
● To filter the tasks by the status active or archive add the filter “status” as an int array:
filter={"status":[18],...}
Active: 1
Archived: 18


DONE
● The search result should be shown as a list of tasks. Each entry shows the project name
of the task and the task name itself.

DONE
● An empty search field should clear the search result again.

DONE
● Clicking on the X clears the search field.

DONE 
● A click on a task should just show an info dialog with the task name.

DONE
● The results should be saved into a database in a simple form. Only a Task table is
desired, which saves all needed data.

DONE : If internet connected there will be server search or, It will be local search
● The available database data should be used for an offline search.

DONE : Everythinng is written in kotlin Except Pojo Classes. Because, Some Unknown SIGBart error was coming with the kotlin declared class so finally, I changed to Java class.

● The code should be written in Kotlin (no need for RxJava or Dagger, please use
DataBinding, LiveData and Room).

Nice to have:

DONE 
● The search should start delayed 400ms after the last text change. So, not every typed
character triggers a search request.

DONE
● During the search a loading indicator should be shown (position it where you want)

DONE 
● Please use your own icons. You find the desired design on the second page. No need for pixel
perfect, use the platform common margins, styles and colors.
