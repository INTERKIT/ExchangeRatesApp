<h1 align="center">Atlant Blockchain Android App</h1><br>

<p align="center">
  <a href="#"><img alt="Organization" src="https://avatars.githubusercontent.com/u/152767650?s=20"/></a>
  <a href="#"><img alt="Android OS" src="https://img.shields.io/badge/OS-Android-3DDC84?style=flat-square&logo=android"></a>
  <a href="#"><img alt="Languages-Kotlin" src="https://flat.badgen.net/badge/Language/Kotlin?icon=https://raw.githubusercontent.com/binaryshrey/Awesome-Android-Open-Source-Projects/master/assets/Kotlin_Logo_icon_white.svg&color=f18e33"/></a>
<a href="#"><img alt="PRs" src="https://img.shields.io/badge/PRs-Welcome-3DDC84?style=flat-square"></a>
</p>


## Overview
The app must download and update rates every 1 second using the API https://revolut.duckdns.org/latest?base=EUR.
List all currencies you get from the endpoint (one per row). Each row has an input where you can enter any amount of money. When you tap on a currency row, it should slide to the top and its input becomes the first responder. When you’re changing the amount, the app must simultaneously update the corresponding value for other currencies.

The app follows MVP principles. The Presenter handles the logic of downloading and updating rates from the API every second. It updates the View with the new data, ensuring that the View displays the list of currencies and handles user interactions. The Model represents the data, and the Presenter interacts with the Model to fetch and update the rates. This architecture separates the concerns, making the codebase easier to manage and test.

<img src="https://github.com/INTERKIT/ExchangeRatesApp/blob/master/screenshots/screen_main.gif" alt="drawing" width="320"/>

```
cd existing_repo
git remote add origin git@github.com:INTERKIT/ExchangeRatesApp.git
git branch -M main
git push -uf origin main
```

### :office: Dependencies
|Libraries| Usage |
|--|--|
|[Retrofit](https://square.github.io/retrofit/)| A type-safe HTTP client for Android and Java. For more information please see the website. Handling of the |
|[Koin](https://github.com/InsertKoinIO/koin-getting-started/blob/main/README.md)|A pragmatic lightweight dependency injection framework for Kotlin developers.|
|[Glide](https://github.com/bumptech/glide/blob/master/README.md)| Fast and efficient open source media management and image loading framework for Android |
|[Coroutines](https://developer.android.com/kotlin/coroutines)| A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously |
|[Timber](https://github.com/JakeWharton/timber)| This is a logger with a small, extensible API which provides utility on top of Android's normal Log class. |
|[Socket](https://socket.io/blog/native-socket-io-and-android/)| Socket.IO provides an event-oriented API that works across all networks, devices and browsers. It's incredibly robust (works even behind corporate proxies!) and highly performant, which is very suitable for multiplayer games or realtime communication. |


## :memo: Support
If you encounter any issues or have questions, please contact our support team at business@interkit.io or visit our [website](https://www.interkit.io/).

## :memo: Feedback
We value your feedback! Share your suggestions and experiences to help us improve the Chama Challenge app. Leave a review on the Google Play Store or contact us directly through the app.

Enjoy the Github Trend and make this year's event unforgettable with the Github Trend Challenge app!
