# BytetestBack

```
@startuml


package Folder <<src.main.java>>{
  left to right direction
  Folder com.henrryagc.bytest {
    folder customer {
      class "CustomerController"
      class "CustomerDTO"
      class "CustomerMapper"
      interface "CustomerRepository"
      class "CustomerService"
    }
    folder db.model {
      class "categoryEntity"
      class "CustomerEntity"
      class "EmployeeEntity"
      class "OrderDetailEntity"
      class "OrderEntity"
      class "ProductEntity"
      class "ShipperEntity"
      class "SupplierEntity"
    }
    folder orderdetail {
    interface "OrderDetailRepository"
    
    }
    folder employee {
    }
  }
}

employee --[hidden]> orderdetail

@enduml

```