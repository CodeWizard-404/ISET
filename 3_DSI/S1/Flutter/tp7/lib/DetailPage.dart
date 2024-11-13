import 'package:flutter/material.dart';
import 'Impaire.dart';

class DetailPage extends StatelessWidget {
  const DetailPage({super.key});

  @override
  Widget build(BuildContext context) {
    final impaire = ModalRoute.of(context)?.settings.arguments as Impaire?;

    if (impaire == null) {
      return Scaffold(
        appBar: AppBar(title: const Text('Detail Page')),
        body: const Center(child: Text('Error: No data found.')),
      );
    }

    return Scaffold(
      appBar: AppBar(
        title: Text(impaire.lib),
      ),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Text(impaire.lib),
            Text('Valeur => ${impaire.val}'),
            ElevatedButton(
              onPressed: () {
                Navigator.pop(context, impaire);
              },
              child: const Text('Return'),
            ),
          ],
        ),
      ),
    );
  }
}
