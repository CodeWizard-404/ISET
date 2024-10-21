import 'package:flutter/material.dart';

class DetailPage extends StatelessWidget {
  String lib;
  int val;

  DetailPage({ required this.lib, required this.val});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(lib),
      ),
      body: Center(
        child: Column(
          children: [
            Text(lib),
            Text('Val: $val'),
          ],
        ),
      ),
    );
  }
}
