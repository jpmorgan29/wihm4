# WIHM 
**Wireless Heart Monitor**
---


![N|Solid](https://scontent-bru2-1.xx.fbcdn.net/v/t35.0-12/18697538_10154385345131744_2016130272_o.png?oh=f1552d5ec59fa4e10aec58d5818ba457&oe=5927E838)
![N](https://scontent-bru2-1.xx.fbcdn.net/v/t35.0-12/18674895_10154382731281744_1514994551_o.jpg?oh=49e5ceabfc4ad734154122682728d6c7&oe=5927FB0E)
---
# Requirements

  - Android smartphone/tablet with Bluetooth 4.0
  - Fitrax wristband
---
# How it works
 ### 1. Open the WIHM application and register.
 ![N](https://scontent-bru2-1.xx.fbcdn.net/v/t35.0-12/18676745_10154385345026744_1493557762_o.png?oh=30c40be5fee189a2fdd82a24f43118e7&oe=5927EF24)
 ### 2. Go back to the main activity and select 'start monitoring'.
 ![N](https://scontent-bru2-1.xx.fbcdn.net/v/t35.0-12/18721361_10154385345061744_1525186299_o.png?oh=ccedae127374191a8858de2cd575ef2b&oe=5927AEBF)
 ### 3. Put the battery in the wristband so you see the green light on the wristband
 ![N](https://scontent-bru2-1.xx.fbcdn.net/v/t35.0-12/18641772_10154382731206744_2119619095_o.jpg?oh=a9e42ac80df88fed4f945c8bee250665&oe=5927FEC7)
 ### 4. Once registered, select your name in the list
 ![N](https://scontent-bru2-1.xx.fbcdn.net/v/t35.0-12/18675227_10154385344991744_1250710490_o.png?oh=421102f2a91549c7320c767744d90cea&oe=5927D065)
 #### (Once selected, the application will ask for permission to turn on the bluetooth if bluetooth is not on yet)
![N](https://scontent-bru2-1.xx.fbcdn.net/v/t35.0-12/18697646_10154385344926744_1506581206_o.png?oh=32c0044f2c5c54bcbc047bc4cec26020&oe=5927FACB)

### 5. You will get a list of bluetooth devices and select your Fitrax device.

### 6. Once your phone is paired with the Fitrax device, you will get your current BPM that is refreshing every second and is being stored to the database and shown on the graph.

![N](https://scontent-bru2-1.xx.fbcdn.net/v/t35.0-12/18720691_10154385402446744_1888942451_o.png?oh=c510e633ade2df972382c75d95ab2699&oe=5927B037)
 #### The database is sorted by userid and has your registered information stored and your heartbeatdata is stored per date
 ![N](https://scontent-bru2-1.xx.fbcdn.net/v/t34.0-12/18716377_10154385407296744_561645714_n.png?oh=80e4672c9a2b4a8742dd65d9306eaeda&oe=592814DC)
![N](https://scontent-bru2-1.xx.fbcdn.net/v/t35.0-12/18675188_10154385407311744_1678813300_o.png?oh=2552b4c3d4ee0198572f315245b14239&oe=5927E20D)
 ---
 
 # You can also:
  - Select multiple users at the same time
  - Review your sessions
 ---
# Technical details
- Android based application
- Firebase database
- Fitrax wristband
-- Arduino based application
-- 3V Battery
-- 32-bit system on chip with Bluetooth Low Energy
-- Ambient green light sensor
-- Opamp with passive components



---

# How to create the Fitrax wristband:
### PCB-design of the wristband:

![N](https://scontent-bru2-1.xx.fbcdn.net/v/t34.0-12/18685367_10154385423451744_327884777_n.png?oh=fbf26dca7dc2d87598f5a0c948234c0c&oe=5927F140)

### Arduino code:
> Go in the 'Arduino' directory to find the code behind the Fitrax hardware application.




# Credits

  - Robin Anthonissen
  - John Paul Morgan
  - Emilia Ryhanen

