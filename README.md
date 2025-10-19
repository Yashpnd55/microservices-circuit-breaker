Circuit breaker helps to keep the consumer(source) app to not to it the producer(destination) app when it is down.
It keep the track based on the statuses.
1. CLOSED - default CLOSED, when smooth connection between consumer and producer is happening.
2. OPEN - hwne the producer is down, and the threashold frequency is reached, it goes to OPEN state when it stops hitting the prodcuer and just runs the fallback method for the given time duration.
3. HALF OPEN - when the time duration from open state is over, then it goes to half open where few hits that are configured for half open state, hits the producer and
    - if connection established, then once the hits are completed, goe back to closed state
    - if connection not established, again goes back to open state

NOTE: When in closed state, if the producer is down, and threshold is not reached, then fallback method is executed and it keeps hitting the down producer until threashold is reaced and it goes in open state
