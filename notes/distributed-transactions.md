###Oracle RDB
The *two-phase commit protocol* coordinates the activity of participants in a transaction to ensure that every required operation is completed before a transaction is made permanent, even if the transaction is a distributed transaction.

Participants:
*Resource manager:* responsible for maintaining and recovering its own resources.
*Transaction manager:* coordinates the actions of the resource managers that are located on the same node (local resource managers) as the transaction manager.
*Coordinator:* The coordinator is a transaction manager on the node where the application started the transaction. The coordinator orchestrates the distributed transaction by communicating with transaction managers on other nodes (remote transaction managers) and with resource managers on the same node (local resource managers).
