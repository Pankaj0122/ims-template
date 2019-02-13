# Kmeans Algorithm
Kmeans algorithm is an iterative algorithm that tries to partition the dataset into K pre-defined distinct non-overlapping subgroups (clusters) where each data point belongs to only one group. It tries to make the inter-cluster data points as similar as possible while also keeping the clusters as different (far) as possible. It assigns data points to a cluster such that the sum of the squared distance between the data points and the cluster’s centroid (arithmetic mean of all the data points that belong to that cluster) is at the minimum. The less variation we have within clusters, the more homogeneous (similar) the data points are within the same cluster.

The way kmeans algorithm works is as follows:


* Specify number of clusters K.
* Initialize centroids by first shuffling the dataset and then randomly selecting K data points for the centroids without replacement.
* Keep iterating until there is no change to the centroids. i.e assignment of data points to clusters isn’t changing.
* Compute the sum of the squared distance between data points and all centroids.
* Assign each data point to the closest cluster (centroid).
* Compute the centroids for the clusters by taking the average of the all data points that belong to each cluster.

# Applications:
* Customer Segmentation: Subdivision of customers into groups/segments such that each customer segment consists of customers with similar market characteristics — pricing , loyalty, spending behaviors etc. Some of the segmentation variables could be e.g., number of items bought on sale, avg transaction value, total number of transactions. Customer segmentation allows businesses to customize market programs that will be suitable for each of its customer segments.
* Anomaly or Fraud Detection:
  Separate valid activity groups from bots
  Detect fraudulent claims.
* Inventory Categorization based on sales or other manufacturing metrics
* Creating News Feeds: K-Means can be used to cluster articles by their similarity — it can separate documents into disjoint clusters.
* Cloud Computing Environment: Clustered storage to increase performance, capacity, or reliability — clustering distributes workloads to each server, manages the transfer of workloads between servers, and provides access to all files from any server regardless of the physical location of the file.
* Environmental risks: K-means can be used to analyze environmental risk in an area — environmental risk zoning of a chemical industrial area.
* Pattern Recognition in images: For example, to automatically detect infected fruits or for segmentation of blood cells for leukaemia detection

# ims-template
Java template project for intelligent measurement systems

Library used in the code for drawing plots: https://github.com/yannrichet/jmathplot



# build

```
git clone https://github.com/jwszolek/ims-template.git
cd ./ims-template
mvn clean install
```

# run

```
git clone https://github.com/jwszolek/ims-template.git
cd ./ims-template
mvn exec:java -Dexec.mainClass=com.ksdir.ims.Runner
```




