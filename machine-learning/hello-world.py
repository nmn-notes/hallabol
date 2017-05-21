from sklearn import tree
features = [[140, 0], [130, 0], [150, 1], [170, 1]]
labels = [0, 0, 1, 1]
classifier = tree.DecisionTreeClassifier()
classifier = classifier.fit(features, labels)
print classifier.predict([[150, 1]])
