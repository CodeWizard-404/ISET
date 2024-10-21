import 'package:flutter/material.dart';
import 'impaire.dart';

class EntierListPage extends StatelessWidget {
  final List<int> Numbers;

  // Constructor to accept the oddNumbers list
  EntierListPage({required this.Numbers});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Entiers List'),
      ),
      body: ListView.builder(
        itemCount: Numbers.length,
        itemBuilder: (context, index) {
          return ListTile(
            title: Text('Entier ${index + 1}'),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => DetailPage(
                    lib: 'Entier ${index + 1}',
                    val: Numbers[index],
                  ),
                ),
              );
            },
          );
        },
      ),
    );
  }
}
