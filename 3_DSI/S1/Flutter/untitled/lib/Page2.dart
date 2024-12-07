import 'package:flutter/material.dart';

class PageTwo extends StatelessWidget {
  final double average;

  const PageTwo({super.key, required this.average});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Page 2'),
      ),
      body: Center(
        child: Text(
          ' Moyenne = ${average.toStringAsFixed(2)}',
          style: const TextStyle(fontSize: 24),
        ),
      ),
    );
  }
}