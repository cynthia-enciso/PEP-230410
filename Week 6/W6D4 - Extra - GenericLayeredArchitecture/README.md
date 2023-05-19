# Generic Layered Architecture

1. You may want to define your entities first in Model
    - entity: real-world object you want to model
2. Next step, you could define your DAO methods
    - what CRUD operations you want to perform
3. Next step, you could define your service methods
    - calls respective dao method and perform an business logic if needed
    - business logic could be any additional operations needed for decision making, like validation, error handling, etc.
4. Next step, define controller (endpoints and handlers)
5. do any setup in main() method