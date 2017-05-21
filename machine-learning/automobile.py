from sklearn import tree

automobile = {"sports-car": 0, "minivan" : 1}
automobileArray=["sports-car", "minivan"]

horsePowerNoOfSeatsFeature = [[300, 2], [500, 2], [200, 8], [300, 9]]
labels = [automobile["sports-car"], automobile["sports-car"], automobile["minivan"], automobile["minivan"]]

classifier = tree.DecisionTreeClassifier()
classifier = classifier.fit(horsePowerNoOfSeatsFeature, labels)

result = classifier.predict([[150, 7]])

print 'prediction: ' + automobileArray[result[0]]
