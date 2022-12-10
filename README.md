# MultiplayerGame-Kafka

Multiplayer Game using the Pub-Sub Model of Kafka


Initial thoughts :
1. Multiplayer Game Rooms architecture
2. At a time N game rooms will be there
3. In a game only 2 players can play
4. Any player can leave the game at any time - yes rage quit is allowed , lmao !
5. Once a player leaves a match in between ,he gets moved to a ban room, if a player is sent to a ban room more than x times then he is perm banned.
6. Winner deciding is not yet decided , will use a simple game to decide the winner, this is not the crux of the prob
7. this is not a knockout, more like a deathmatch kind of scene where players will keeo playing with whoever they are matched
8. At a time N game rooms with 2*N players max. so rest of the players will wait in a waiting room'
9. New players will come as a live stream of players, so need to use a queue for that, or maybe each new player is a publisher and each waiting player is a consumer.
10. Need to start with LLD now, too much talk .