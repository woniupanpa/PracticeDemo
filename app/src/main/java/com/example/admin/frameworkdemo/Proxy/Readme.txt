1：代码参考：https://blog.csdn.net/u011784767/article/details/78281384
2:静态代理模式：
Student类似明星
Proxy类似经纪人
导演找明星，需要通过经纪人，经纪人会在前面后者后面做一下琐碎的明星不想做的事情
，但是真正演戏的还是明星自己。proxy的作用就是做一些准备后收尾工作。
总结代理模式：当前对象不愿意干的，没法干的东西交托给别的对象来做，我们只要做好本分的东西就行

3:动态代理模式：
1. Proxy.newProxyInstance()方法返回一个代理类的实例，需要传入InvocationHandler的实例h
2. 当新的代理实例调用指定方法时，本质上是InvocationHandler实例调用invoke方法，并传入指定的method类型的参数。