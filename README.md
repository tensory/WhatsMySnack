# What's My Snack?

A demo Android application.

## Architecture

This application uses an MVVM approach built around Android data binding. Views are defined as XML resources with databinding to observable model instances. 

Presenters serve as functional interfaces between view models where the view models need to communicate with each other or an Android component.

## Dependencies

Data:

* Android Room + LiveData
* [RoomAsset](https://github.com/humazed/RoomAsset) helps to load data from a source SQLite DB into Room

Domain:
* Dependencies on data providers injected with Dagger2
* Domain models are observable using Android data binding

Presentation:
* View models implementing `android.databinding.BaseObservable`
* XML layouts binding to model properties.

Other dependencies:
* [AssertJ](http://joel-costigliola.github.io/assertj/assertj-core-quick-start.html) assertions for unit-testing interactions on the SnackList model