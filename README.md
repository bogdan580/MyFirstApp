# MyFirstApp
* My first android application

## Run:
1) add to MyFirstApp/app/src/main/res/values file "google_maps_api.xml":
```
<resources xmlns:android="urn:oasis:names:tc:xliff:document:1.2">
    <string name="google_maps_key" translatable="false" templateMergeStrategy="preserve" >
    YOUR_GOOGLE_MAP_API_KEY
    </string>
</resources>
```
2) in file MyFirstApp/app/src/main/java/com/mbohdan/apps/myFirstApp/ServerApiService.kt change server url:
```
 .baseUrl("http://YOUR_URL:8080/")
```
3) run application

## SCREENS:
Descriptions | Descriptions
------------ | -------------
Main view app | Login Activity
<img src="img/main.png" width="320"> | <img src="img/login_activity.png" width="320">
Scanner fragment | Scanner Activity
<img src="img/scanner_fragment.png" width="320"> | <img src="img/scanner.png" width="320">
Simple menu | Github java developers list 
<img src="img/menu_fragment.png" width="320"> | <img src="img/github_users_find.png" width="320">
News API view | WebView
<img src="img/news_api.png" width="320"> | <img src="img/web_view.png" width="320">
