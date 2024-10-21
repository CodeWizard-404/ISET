import 'package:flutter/material.dart';
import 'list.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    // Generate the list of odd numbers here
    final List<int> Numbers = List.generate(20, (index) => 1 + index * 2);

    return MaterialApp(
      home: EntierListPage(Numbers: Numbers),
    );
  }
}
