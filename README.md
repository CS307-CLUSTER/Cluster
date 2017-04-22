## Cluster

## Getting the frontend to work
Every time a change is done in the bower or css, you need to go to View->Tools Window->Maven Projects.
Then execute the Maven Goal "clean install"

Make sure you have npm installed. Them run npm install bower. If you don't do this, I think you're maven install will fail.

## API Endpoints
All public for now


### Backend (/backend)
**/refresh**<br>
Params: None<br>
Type: GET<br>
Return Type: String<br>

Syncs up Hive with the database, uses on startup, returns with message

### Admin (/admin)
**/getNumActiveUsers**<br>
Params: None<br>
Type: GET<br>
Return Type: Int<br>

Gets the number of active users

**/getNumActiveClusters**<br>
Params: None<br>
Type: GET<br>
Return Type: Int<br>

Gets the number of active clusters

**/disbandCluster**<br>
Params: clusterId<br>
Type: GET<br>
Return Type: boolean<br>

Disbands cluster with the given clusterID, returns true if disbanded successfully

**/getUserInformation**<br>
Params: userId<br>
Type: GET<br>
Return Type: User<br>

Get the user given

### Cluster (/cluster)
**/create**<br>
Params: restaurant_id, maxUsers, minUsers, address, city, state, zip<br>
Type: GET<br>
Return Type: String<br>

Creates a cluster with the given information

**/info**<br>
Params: id<br>
Type: GET<br>
Return Type: Cluster<br>

Gets Cluster object based on id given

**/getAll**<br>
Params: None<br>
Type: GET<br>
Return Type: List<Cluster><br>

Returns a list of all current clusters

**/join**<br>
Params: clusterId<br>
Type: GET<br>
Return Type: boolean<br>

Adds the user to the given cluster, returns true if successful

**/leave**<br>
Params: cluster<br>
Type: GET<br>
Return Type: boolean<br>

Removes the user from the given cluster, returns true if successful

**/getCurrent**<br>
Params: None<br>
Type: GET<br>
Return Type: Cluster<br>

Returns the cluster the user is currently in

**/kick**<br>
Params: userId, clusterId<br>
Type: GET<br>
Return Type: boolean<br>

Removes given user from given cluster, returns true if successful

**/complete**<br>
Params: clusterId<br>
Type: GET<br>
Return Type: Int<br>

Marks a cluster as completed and disbands

### Ratings (/rating)

**/getAll**<br>
Params: None<br>
Type: GET<br>
Return Type: List<User><br>

Gets a list of all the users the current user needs to rate

### Restaurant (/restaurant)

**/add**<br>
Params: id, name, hb_link, rating, hours, min_delivery, delivery_fee, pic_src, address, city, state, zip<br>
Type: GET<br>
Return Type: boolean<br>

Adds a restaurant to database, return true if successfull

**/exists**<br>
Params: id<br>
Type: GET<br>
Return Type: boolean<br>

Check if restaurant with given id exists

**/get**<br>
Params: id<br>
Type: GET<br>
Return Type: Restaurant<br>

Gets the restaurant information of the given id

**/getAll**<br>
Params: None<br>
Type: GET<br>
Return Type: List<Restaurant><br>

Gets the number of users active

### User (/user)

**/info**<br>
Params: None<br>
Type: GET<br>
Return Type: User<br>

Gets the information of the current user

**/getId**<br>
Params: None<br>
Type: GET<br>
Return Type: long<br>

Gets ID of the current user

**/check**<br>
Params: None<br>
Type: GET<br>
Return Type: String<br>

Check if user exists, returns "Users exists"

**/create**<br>
Params: phoneNumber, city, state, zip, address, email<br>
Type: GET<br>
Return Type: String<br>

Creates user with the given information

**/getAll**<br>
Params: None<br>
Type: GET<br>
Return Type: List<User><br>

Gets all users currently active

**/exists**<br>
Params: None<br>
Type: GET<br>
Return Type: boolean<br>

Checks if current users exists, uses context Principal, returns true if exists

**/makeAdmin**<br>
Params: userId<br>
Type: GET<br>
Return Type: boolean<br>

Makes the given user an admin, returns true if successful

**/removeAdmin**<br>
Params: userid<br>
Type: GET<br>
Return Type: boolean<br>

Makes the given user not an admin, returns true if successful

**/upVote**<br>
Params: userId<br>
Type: GET<br>
Return Type: boolean<br>

Up votes the given user, returns true if successful

**/downVote**<br>
Params: userId<br>
Type: GET<br>
Return Type: boolean<br>

Down votes the given user, returns true if successful

**/getUserInformation**<br>
Params: name, number, email<br>
Type: GET<br>
Return Type: boolean<br>

Edits the name, number or email of a given user, returns true if successful