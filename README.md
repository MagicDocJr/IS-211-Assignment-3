# IS-211-Assignment-3 Network Problem

## Description
One of the reason for the success of the TCP/IP internet, is the robustness of the
routing algorithm. The routing algorithm used in IP, is usually a variant of Dijkstra's
Algorithm. The routing algorithm described below is a gross simplification of the real
protocol:<br><br> 
● Each node on the network runs Dijktra's algorithm once, to find the fastest
route from that node to all the other nodes.<br>
● Then the nodes exchange routing tables with their neighbours.<br>
● If a node finds that routing packets through the neigbour is faster than the
best route the node has found, it will update its routing table using data from
the neighbors routing table. <br>
