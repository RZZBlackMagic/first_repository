#ifndef HOMEWORK7-4_H_INCLUDED
#define HOMEWORK7-4_H_INCLUDED

#include "cstring"
#include <iostream>
using namespace std;

template<class e> class ListItem;

template<class e> class List
{
public:
    List<e>():front1(NULL),end1(NULL){}
    List<e>(const List<e> &);
    ~List();
    void insert1(ListItem *ptr,e value);
    int remove1(e value);
    int size1(){return _size;}
private:
    ListItem  front1;
    ListItem  end1;
};

#endif // HOMEWORK7-4_H_INCLUDED
