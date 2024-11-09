import 'package:flutter/material.dart';
import 'Impaire.dart';
import 'DetailPage.dart';

class EntierListPage extends StatelessWidget {
  final List<Impaire> Numbers;

  const EntierListPage({super.key, required this.Numbers});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Entiers List',
          textAlign: TextAlign.center,
          style: TextStyle(
            color: Colors.white,
            fontSize: 35,
            fontWeight: FontWeight.bold,
          ),
        ),
        backgroundColor: Colors.blueAccent,
      ),
      body: ListView.builder(
        itemCount: Numbers.length,
        itemBuilder: (context, index) {
          return Container(
            margin: const EdgeInsets.symmetric(vertical: 5, horizontal: 100),
            decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.circular(8),
              boxShadow: [
                BoxShadow(
                  color: Colors.blueAccent.withOpacity(0.5),
                  blurRadius: 30,
                  offset: const Offset(0, 0),
                ),
              ],
            ),
            child: ListTile(
              title: Text(
                Numbers[index].lib,
                style: const TextStyle(fontSize: 16, fontWeight: FontWeight.w500, color: Colors.blueAccent),
              ),
              trailing: const Icon(Icons.arrow_forward_ios, color: Colors.blueAccent),
              onTap: () async {
                // Navigate to DetailPage and wait for the returned data
                final result = await Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => const DetailPage(),
                    settings: RouteSettings(arguments: Numbers[index]),
                  ),
                );

                if (result != null) {
                  final lib = result['lib'];
                  final val = result['val'];
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(
                      content: Text('$lib value: $val'),
                      duration: const Duration(seconds: 3),
                    ),
                  );
                }
              },
            ),
          );
        },
      ),
    );
  }
}







