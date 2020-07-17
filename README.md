# spring-statemachine-demo
## 状态机优缺点
### 优点
1. 代码结构化、易于维护、扩展。方便后续添加状态、事件。
2. 解耦。将业务逻辑和订单状态改变 进行解耦，将一个大任务拆分成 多个小任务，相互解耦。

### 缺点
1. 类数量增多。有多少状态，对应创建多少事件。
2. 代码结构复杂，不再是 单个类中写满逻辑。

## 参考demo地址:
> * https://www.cnblogs.com/jurendage/p/11818339.html
> * https://gitee.com/wphmoon/statemachine
> * https://www.jianshu.com/p/1a4947a099e9
> * https://docs.spring.io/spring-statemachine/docs/2.2.0.RELEASE/reference/#using-maven


## References
> * Spring Statemachine Goes Reactive with 3.0.0.M1: https://spring.io/blog/2019/08/08/spring-statemachine-goes-reactive-with-3-0-0-m1
> * Spring State Machine: http://projects.spring.io/spring-statemachine/
> * 状态机： https://baike.baidu.com/item/%E7%8A%B6%E6%80%81%E6%9C%BA/6548513
> * 有限状态机实现-状态机介绍: https://www.jianshu.com/p/d48e0d565618
> * 有限状态机通常在什么地方被用到？https://www.zhihu.com/question/31634405
> * State Diagram: http://plantuml.com/en/state-diagram
> * A Guide to the Spring State Machine Project: https://www.baeldung.com/spring-state-machine
> * Reactive State Machines: https://ian.bebbs.co.uk/posts/ReactiveStateMachines
> * Reactive State Machines & Statecharts - Slides: https://slides.com/davidkhourshid/reactive-statecharts
> * RxJS state machine: https://github.com/logicalguess/rx-state-machine
> * RxFsm is a hierarchical finite state machine (FSM) library built on top of RxJava: https://github.com/furuholm/RxFsm
> * State Machine Open Source Projects: https://awesomeopensource.com/projects/state-machine
> * Awesome FSM: https://github.com/soixantecircuits/awesome-fsm
> * Advanced state machines in Java: https://github.com/UnquietCode/JState
> * A Kotlin DSL for finite state machine: https://github.com/Tinder/StateMachine
> * Implementing Simple State Machines with Java Enums: https://www.baeldung.com/java-enum-simple-state-machine
> * Stateless4j: Lightweight Java State Machine https://github.com/stateless4j/stateless4j