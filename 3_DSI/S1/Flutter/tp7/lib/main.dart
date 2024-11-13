import 'package:flutter/material.dart';
import 'list.dart';
import 'Impaire.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    final List<Impaire> Numbers = List.generate(
      20,
          (index) => Impaire(lib: 'Entier: ${1 + index }', val: 1 + index * 2),
    );


    return MaterialApp(
      home: EntierListPage(Numbers: Numbers),
    );
  }
}
