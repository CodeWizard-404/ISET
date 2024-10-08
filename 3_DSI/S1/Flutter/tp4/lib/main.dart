import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Exercice Mise en Page',style: TextStyle(color: Colors.white,fontWeight: FontWeight.bold)),
          backgroundColor: Colors.blue,
        ),
        body: Column(
            children: [
              // Image Section
              Image.asset(
                'assets/images/ISET.jpeg', // Add your image to the assets folder
                width: double.infinity,
                fit: BoxFit.cover,
              ),
              Container(
                height: 4.0,
                color: Colors.green,
              ),
              const Padding(
                padding: EdgeInsets.symmetric(horizontal: 16.0, vertical: 8.0),
                child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text("ISET CHARGUIA", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
                          Text("Tunisie, Tunis", style: TextStyle(fontSize: 12)),
                        ],
                      ),
                      Column(
                        children: [
                          Icon(Icons.star, color: Colors.orange,),
                          Text("1853")
                        ],
                      ),

                    ]
                ),
              ),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 8.0, vertical: 8.0),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children:[ Container(
                      child: Column(
                          Icon(Icons.call), // Replace with specific icons as needed
                          SizedBox(height: 8),
                          Text("Call "), // Replace with specific texts as needed

                      ),
                    ),
                  }),
                ),
              ),

              Padding(
                padding: const EdgeInsets.all(16.0),
                child: Text("The Institut Supérieur des Études Technologiques de Charguia, commonly abbreviated ISET Charguia or ISETch, was created by virtue of Decree no. 2000-981, dated 11 May 2000. It falls under the General Direction of Technogical Studies of the Ministry of Higher", style: TextStyle(fontSize: 14)),
              ),
            ],
        ),
      ),
    );
  }
}
