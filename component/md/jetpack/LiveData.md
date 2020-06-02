
LiveData的数据发生改变时，会自动通知所有观察者。  

## MutableLiveData
```
        val userLiveData = MutableLiveData<User>()
        // Observer
        val userObserver = Observer<User> { user -> btn_test.text = user.name }
        // observe
        userLiveData.observe(this, userObserver)
        // 改变数据
        btn_test.setOnClickListener { userLiveData.value = User("", "xxx", "") }
```

## Transformations#map()
```
        val userNameLiveData = Transformations.map(userLiveData) { user -> user.name }
        val userNameObserver = Observer<String> { userName -> btn_test.text = userName }
        userNameLiveData.observe(this, userNameObserver)
```
## 

## Transformations#switchMap()

## 无需解除订阅
LiveData 只会通知处于 Active 状态的观察者，如果一个观察者处于 Paused 或 Destroyed 状态，它将不会受到通知。
所以 LiveData 不需要在 Activity/Fragment 的 onPause 或 onDestroy 中接触订阅。
一旦观察者重新恢复 Resumed 状态，它将会重新收到 LiveData 的最新数据。