Question: think of a way/ways to handle huge spikes of assessment submissions (procrastinating students waiting till the last moment)

The below are some ways to handle huge spikes at last moment
1: Use Asynchronous Processing using the Message queue like kafka for high throughput
2: We can use cloud environment for deployment such as AWS,  where I can Horizontally scale this application by adding more number of instances.
3: We can use AWS Auto-Scaling which can handle the spike based on event or at a particular time period.
Later it can shrink in his normal position. so we can use that one also for last moment rush
4: Yes, Off-course we need to use a Application load balancer to distribute the traffic in multiple instances based on best suitable algorithm. 
5: We can use Redis,to reduce the number of direct hit to database, we can figure out which parameters are accessing frequently so that we can create db indexes as per business need. 

6: Monitoring the System: Use monitoring tools like Prometheus and Grafana to track system metrics and detect issues.
Alerts: Set up alerts to notify you of system issues or performance degradation. such as cloud watch  for monitoring and SNS for high spike notifications.

Thanks