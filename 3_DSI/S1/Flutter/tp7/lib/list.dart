import 'package:flutter/material.dart';
import 'Impaire.dart';
import 'DetailPage.dart';

class EntierListPage extends StatefulWidget {
  final List<Impaire> Numbers;

  const EntierListPage({super.key, required this.Numbers});

  @override
  _EntierListPageState createState() => _EntierListPageState();
}

class _EntierListPageState extends State<EntierListPage> {
  TextEditingController resultController = TextEditingController();

  @override
  void initState() {
    super.initState();
    resultController.text = "Valeur Initial";
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Entiers List'),
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: resultController,
            ),
          ),
          Expanded(
            child: ListView.builder(
              itemCount: widget.Numbers.length,
              itemBuilder: (context, index) {
                return ListTile(
                  title: Text(widget.Numbers[index].lib),
                  trailing: const Icon(Icons.arrow_forward_ios),
                  onTap: () async {
                    final result = await Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const DetailPage(),
                        settings: RouteSettings(arguments: widget.Numbers[index]),
                      ),
                    );

                    if (result != null) {
                      setState(() {
                        resultController.text = '${result.lib}, Value: ${result.val}';
                      });
                    }
                  },
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}
