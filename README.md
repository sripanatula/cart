Your	solution	should	not	be	database	driven.	

SCENARIO:		

Let’s	imagine	a	situation	where	a	user	is	shopping	for	flights.	He/she	has	a	shopping	cart	in	which	he	can	pick	and	choose	different	flights	that	he/she	wants	to	book.		

Each	flight	has	an	airline	card	fee	associated	with	them	that	can	change	at	any	time	during	booking,	based	on	what	credit	card	the	user	enters.	E.g.	the	fee	could	be	$2	for	Visa,	$3	for	MasterCard,	etc.		

The	user	tries	to	use	different	credit	card	types	in	order	to	find	out	what	fee	is	best	suited	for	him/her.		

Once	the	user	has	figured	out	which	card	to	use,	he/she	books	all	the	flights	together.		

For	this	successful	trip,	a	unique	SUCCESS_ID	is	generated	that	will	hold	all	the	information	for	this	trip.		


QUESTION:		Design	a	system	where	for	each	successful	trip,	the	different	card	types	and	the	fees	associated	with	it	are	stored.	Bear	in	mind	that	a	particular	trip	can	have	multiple	flights.	Also,	we	need	to	be	able	to	store	the	exact	card	used	for	the	booking	of	this	trip.	The	system	needs	to	be	scalable.		

Please	use	descriptive	class	names,	variable	names	and	method	signatures	for	your	solution.	Also,	please	add	descriptions	for	all	the	methods	created.	Justify	your	answer,	explain	your	choices	and	identify	any	drawbacks	to	your	solution,	and	note	any	assumptions	you	have	made.		


API	REFERENCE:		For	a	particular	SUCCESS_ID,	we	can	get	the	booked	cart	information:	

getBookedCart(int	SUCCESS_ID)	{	
				…					
				return	List<FlightComponent>;	
}	

For	a	particular	flight,	the	card	types	that	are	supported	(which	the	user	can	use	to	book):	
getCardTypes(int	FlightID)	{
					….				
					return	List<CardType>;	
}		


For	a	particular	card	number	entered,	the	fees	can	be	returned	by:	
getCardFees(long	cardNumber)	{		
	….					
	return	double	amount;	
}	

USE	CASES:	
1.For	a	particular	SUCCESS_ID,	we	need	to	be	able	to	retrieve	the	total	fees	that	the	user	paid	as	part	of	airline	card	fees	for	all	flights.	
2. For	a	particular	SUCCESS_ID,	we	need	to	be	able	to	retrieve	the	card	type	used	to	complete	the	booking.	
3.For	a	particular	SUCCESS_ID,	we	need	to	be	able	to	retrieve	the	fee	range	for	all	flights.	This	means	we	need	the	minimum	and	maximum	of	fees	of	all	flights.	
4. For	Q3,	can	the	range	also	pass	the	card	type	associated	with	it?	
5.We	need	to	be	able	to	find	out	the	total	number	of	bookings	that	were	done	with	a	particular	card	type.	For	example,	the	total	bookings	done	by	a	VISA	credit	card.	

BONUS:	
6. An	analyst,	wants,	in	real	time	to	see	the	number	of	attempts	that	the	user	made	while	entering	different	credit	cards.	Can	there	be	any	logging	associated	that	helps	the	analyst?	