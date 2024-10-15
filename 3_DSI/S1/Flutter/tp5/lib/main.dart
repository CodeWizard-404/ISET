import 'package:flutter/material.dart';
import 'package:tp5/Pages/Page1.dart';
import 'package:tp5/Pages/Page2.dart';
import 'package:tp5/Pages/HomePage.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Main',
      routes: {
        '/Page1': (context) => Page1(),
        '/Page2': (context) => Page2(),
        '/HomePage': (context) => HomePage(),
        // Add more pages here as needed
      },
      initialRoute: '/HomePage',
      //home: const HomePage(),
    );
  }
}


