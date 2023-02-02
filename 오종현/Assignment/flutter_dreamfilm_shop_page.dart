import 'package:dreamfilm/models/shop_item_products.dart';
import 'package:dreamfilm/models/theme.dart';
import 'package:dreamfilm/screen/shop/about_ad_page.dart';
import 'package:dreamfilm/screen/shop/about_backgrounditem_page.dart';
import 'package:dreamfilm/screen/shop/about_item_page.dart';
import 'package:dreamfilm/screen/shop/about_textstyleitem_page.dart';
import 'package:dreamfilm/screen/shop/purchase_record_page.dart';
import 'package:dreamfilm/widgets/icon_button.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:transition/transition.dart';
import 'package:url_launcher/url_launcher.dart';

class ShopPage extends StatelessWidget{
  const ShopPage({Key? key}) : super(key: key);

  @override 
  Widget build(BuildContext context){
    final size = MediaQuery.of(context).size;
    final brightness = Theme.of(context).brightness;
    return Scaffold(
      appBar: AppBar(
        iconTheme: Theme.of(context).iconTheme,
        leading: const SizedBox(width: 20, height: 20,),
        title: Center(child: Text('<<   S H O P   >>', style: TextStyle(fontWeight: FontWeight.bold, color: (brightness == Brightness.light) ? Appcolors.textDark : Appcolors.textLight),),),
        backgroundColor: Colors.transparent,
        elevation: 0,
        actions: [
          Padding(
              padding: const EdgeInsets.only(right: 20),
              child: Center(
                child: IconBorder(
                  icon: Icons.shopping_cart,
                  onTap: (){
                    Navigator.of(context).push(Transition(child: const PurchageRecordPage(), transitionEffect: TransitionEffect.FADE));
                  },
                ),
              ),
            )
        ],
      ),
      body: SingleChildScrollView(
        child: Column(children: [
          Row(mainAxisAlignment: MainAxisAlignment.spaceEvenly, children: const [
            Flexible(
              flex: 1,
              child: SizedBox.shrink()),
            Flexible(
              flex: 4,
              fit: FlexFit.loose,
              child: Divider(color: Appcolors.cardDark,)),
            Text(' 무료 조각 ', style: TextStyle(fontSize: 20),),
            Flexible(
              flex: 4,
              fit: FlexFit.loose,
              child: Divider(color: Appcolors.cardDark,)),
            Flexible(
              flex: 1,
              child: SizedBox.shrink()),
          ],),
          const SizedBox(height: 20,),
          Row(crossAxisAlignment: CrossAxisAlignment.center, mainAxisAlignment: MainAxisAlignment.spaceEvenly, children: const [
            AdCard(index: 0),
            AdCard(index: 1),
          ],),
          const SizedBox(height: 20,),
      
          Row(mainAxisAlignment: MainAxisAlignment.spaceEvenly, children: const [
            Flexible(
              flex: 1,
              child: SizedBox.shrink()),
            Flexible(
              flex: 4,
              fit: FlexFit.loose,
              child: Divider(color: Appcolors.cardDark,)),
            Text(' 글씨체 ', style: TextStyle(fontSize: 20),),
            Flexible(
              flex: 4,
              fit: FlexFit.loose,
              child: Divider(color: Appcolors.cardDark,)),
            Flexible(
              flex: 1,
              child: SizedBox.shrink()),
          ],),
          const SizedBox(height: 20,),
          Row(crossAxisAlignment: CrossAxisAlignment.center, mainAxisAlignment: MainAxisAlignment.spaceEvenly, children: const [
            TextStyleCard(index: 5),
            TextStyleCard(index: 6),
            TextStyleCard(index: 7),
          ],),
          const SizedBox(height: 10,),
          Row(crossAxisAlignment: CrossAxisAlignment.center, mainAxisAlignment: MainAxisAlignment.spaceEvenly, children: const [
            TextStyleCard(index: 8),
            TextStyleCard(index: 9),
            TextStyleCard(index: 10),
          ],),
          const SizedBox(height: 20,),

          Row(mainAxisAlignment: MainAxisAlignment.spaceEvenly, children: const [
            Flexible(
              flex: 1,
              child: SizedBox.shrink()),
            Flexible(
              flex: 4,
              fit: FlexFit.loose,
              child: Divider(color: Appcolors.cardDark,)),
            Text(' 배경 스타일 ', style: TextStyle(fontSize: 20),),
            Flexible(
              flex: 4,
              fit: FlexFit.loose,
              child: Divider(color: Appcolors.cardDark,)),
            Flexible(
              flex: 1,
              child: SizedBox.shrink()),
          ],),
          const SizedBox(height: 20,),
          Row(crossAxisAlignment: CrossAxisAlignment.center, mainAxisAlignment: MainAxisAlignment.spaceEvenly, children: const [
            ItemBackgroundCard(index: 2),
            ItemBackgroundCard(index: 3),
            ItemBackgroundCard(index: 4),
          ],),
          const SizedBox(height: 20,),
      
          // Row(mainAxisAlignment: MainAxisAlignment.spaceEvenly, children: const [
          //   Flexible(
          //     flex: 1,
          //     child: SizedBox.shrink()),
          //   Flexible(
          //     flex: 4,
          //     fit: FlexFit.loose,
          //     child: Divider(color: Appcolors.cardDark,)),
          //   Text(' 기억의 조각 ', style: TextStyle(fontSize: 20),),
          //   Flexible(
          //     flex: 4,
          //     fit: FlexFit.loose,
          //     child: Divider(color: Appcolors.cardDark,)),
          //   Flexible(
          //     flex: 1,
          //     child: SizedBox.shrink()),
          // ],),
          // const SizedBox(height: 20,),
          // Row(crossAxisAlignment: CrossAxisAlignment.center, mainAxisAlignment: MainAxisAlignment.spaceEvenly, children: [
          //   ButterCard(size: size, index: 0),
          //   ButterCard(size: size, index: 1),
          //   ButterCard(size: size, index: 2),
          // ],),
          // const SizedBox(height: 20,),
      
        ],),
      )
    );
  }
}

class AdCard extends StatelessWidget {
  const AdCard({
    Key? key,
    required this.index
  }) : super(key: key);

  final int index;

  @override
  Widget build(BuildContext context) {
    return InkWell(
      borderRadius: BorderRadius.circular(8),
      onTap: (){
        Navigator.of(context).push(MaterialPageRoute(builder: (context) => AboutADShop(product: products[index])));
      },
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            padding: const EdgeInsets.all(20),
            height: MediaQuery.of(context).size.width*0.4,
            width: MediaQuery.of(context).size.width*0.3,
            decoration: BoxDecoration(
              color: products[index].color,
              borderRadius: BorderRadius.circular(16),
            ),
            child: Image.asset(products[index].image)
          ),
          Padding(
            padding: const EdgeInsets.only(top: 5, bottom: 1),
            child: Text(products[index].title, style: const TextStyle(fontSize: 17, fontWeight: FontWeight.bold),),
          ),
          Text('+ ${products[index].price} 조각', style: const TextStyle(fontSize: 14),)
        ],
      ),
    );
  }
}

class ItemCard extends StatelessWidget {
  const ItemCard({
    Key? key,
    required this.index
  }) : super(key: key);

  final int index;

  @override
  Widget build(BuildContext context) {
    return InkWell(
      borderRadius: BorderRadius.circular(8),
      onTap: (){
        Navigator.of(context).push(MaterialPageRoute(builder: (context) => AboutShop(product: products[index])));
      },
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            padding: const EdgeInsets.all(20),
            height: MediaQuery.of(context).size.width*0.4,
            width: MediaQuery.of(context).size.width*0.3,
            decoration: BoxDecoration(
              color: products[index].color,
              borderRadius: BorderRadius.circular(16),
            ),
            child: Image.asset(products[index].image)
          ),
          Padding(
            padding: const EdgeInsets.only(top: 5, bottom: 1),
            child: Text(products[index].title, style: const TextStyle(fontSize: 17, fontWeight: FontWeight.bold),),
          ),
          Text('${products[index].price} 조각', style: const TextStyle(fontSize: 14),)
        ],
      ),
    );
  }
}

class ItemBackgroundCard extends StatelessWidget {
  const ItemBackgroundCard({
    Key? key,
    required this.index
  }) : super(key: key);

  final int index;

  @override
  Widget build(BuildContext context) {
    return InkWell(
      borderRadius: BorderRadius.circular(8),
      onTap: (){
        showCupertinoDialog(context: context, builder: (context) {
          return CupertinoAlertDialog(
            title: const Text('알림'),
            content: const Text('이 부분은 열심히 개발중입니다...1인 개발자라 속도가 느린 점 양해 부탁드려요ㅠ.ㅠ'),
            actions: [
                CupertinoDialogAction(isDefaultAction: true, child: const Text("확인"), onPressed: () {
                  Navigator.pop(context);
                })
            ],
          );
        });
        //Navigator.of(context).push(MaterialPageRoute(builder: (context) => AboutBackgroundShop(product: products[index])));
      },
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            padding: const EdgeInsets.all(20),
            height: MediaQuery.of(context).size.width*0.4,
            width: MediaQuery.of(context).size.width*0.3,
            decoration: BoxDecoration(
              color: products[index].color,
              borderRadius: BorderRadius.circular(16),
            ),
            child: Image.asset(products[index].image)
          ),
          Padding(
            padding: const EdgeInsets.only(top: 5, bottom: 1),
            child: Text(products[index].title, style: const TextStyle(fontSize: 17, fontWeight: FontWeight.bold),),
          ),
          Text('${products[index].price} 조각', style: const TextStyle(fontSize: 14),)
        ],
      ),
    );
  }
}

class TextStyleCard extends StatelessWidget {
  const TextStyleCard({
    Key? key,
    required this.index
  }) : super(key: key);

  final int index;

  @override
  Widget build(BuildContext context) {
    return InkWell(
      borderRadius: BorderRadius.circular(8),
      onTap: (){
        Navigator.of(context).push(MaterialPageRoute(builder: (context) => AboutTextStyleShop(product: products[index])));
      },
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            padding: const EdgeInsets.all(20),
            height: MediaQuery.of(context).size.width*0.4,
            width: MediaQuery.of(context).size.width*0.3,
            alignment: Alignment.center,
            decoration: BoxDecoration(
              color: products[index].color,
              borderRadius: BorderRadius.circular(16),
            ),
            child: Text('다람쥐\n쳇바퀴\n타고파', style: products[index].fonts)
          ),
          Padding(
            padding: const EdgeInsets.only(top: 5, bottom: 1),
            child: Text(products[index].title, style: products[index].titleFonts),
          ),
          Text('${products[index].price} 조각', style: products[index].priceFonts,)
        ],
      ),
    );
  }
}

class ButterCard extends StatelessWidget {
  const ButterCard({
    Key? key,
    required this.size,
    required this.index
  }) : super(key: key);

  final Size size;
  final int index;

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        GestureDetector(
          onTap: (){
            showCupertinoDialog(context: context, builder: (context){
              return CupertinoAlertDialog(
                title: const Text('결제 알림'),
                content: const Text('구글플레이 판매자 계정에 일시적으로 문제가 있기 때문에 급하신 분들은 옾챗으로 컨텍 부탁드립니다ㅜ.ㅜ'),
                actions: [
                  CupertinoDialogAction(isDefaultAction: true, child: const Text("컨텍"), onPressed: () async {
                    Uri url = Uri.parse('https://docs.google.com/document/d/1ZDxeYSH7_HFY29KAsWuHnJN21pioarHAneg0mn0GTdc/edit?usp=sharing');
                    if(await canLaunchUrl(url)){
                      await launchUrl(url);
                    }
                  }),
                  CupertinoDialogAction(isDefaultAction: true, child: const Text("취소"), onPressed: () {
                    Navigator.pop(context);
                  }),
                ],
              );
            });
          },
          child: Container(
            padding: const EdgeInsets.all(20),
            width: size.width * 0.3,
            height: size.width * 0.4,
            decoration: BoxDecoration(
              color: butters[index].color,
              borderRadius: BorderRadius.circular(16),
            ),
            child: Image.asset(butters[index].image),
          ),
        ),
        Padding(
          padding: const EdgeInsets.only(top: 5, bottom: 1),
          child: Text(butters[index].title, style: const TextStyle(fontSize: 17, fontWeight: FontWeight.bold),),
        ),
        Text(butters[index].price, style: const TextStyle(fontSize: 14),)
      ],
    );
  }
}
