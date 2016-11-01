###Singleton Pattern
One instance of class

###Factory Pattern
Hide complex instance creation logic from client, client access the created object only by interface.

###Builder Pattern
Client provides several parameters to builder class

###Prototype Pattern
Prototype pattern is used when it is easier to clone than to create.

###Object Pool Pattern
Reuses and shares objects that are costly to create.
String pool, Thread pool, connection pool

###Iterator Pattern
Helps to iterate collections without exposing internal implementation.

###Observer Pattern
Many listeners for change of object's state.

###Observable class
addObserver(), deleteObserver(), setChanged(), clearChanged(), notifyObservers(Object arg)
Observer Interface
void update(Observable o, Object arg)

###Template Method Pattern
Inheritance

###Chain of responsibility Pattern
CoR is used when the exact handler of the request is not known but the path on which it can be consumed is known well.
GUI, Servlet Filters

###Command Pattern
Command is inside an object which can be parameterized by its setters or constructor.

###Mediator Pattern
Mediator pattern provides a stage for the participating to play so that they remain loosely coupled with each other.
Layout managers in GUI application.

###Strategy Pattern
When a bunch of algorithm needs to be applied interchangeably on an object.
Insurance
BrakeBehaviour
Random/Sticky/RoundRobin selection strategy among instance

###Visitor Pattern
Allows heterogenous collection of objects to be iterated by a visitor.

###Null Object Pattern
When actual handler is not yet ready to use.

###Adaptor Pattern
Makes two class work together by making their interfaces compatible.

###Proxy Pattern
When we use wrapper objects.
Spring AOP

###Decorator Pattern
Add functionality to existing class.

###Facade Pattern
Hide complex internal API

###Composite Pattern
