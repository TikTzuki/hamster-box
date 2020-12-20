import {Button, Collapse, Hidden, Link, MenuItem, MenuList} from '@material-ui/core';
import React from 'react';
import {Link as LinkRoute} from 'react-router-dom';

interface MenuItemDropDown {
  name: string,
  to: string,
  dropdownList?: MenuItemDropDown[]
}

const listMenu:MenuItemDropDown[] = [
  {
    name:"Home",
    to: "/"
  },
  {
    name: "Hamster",
    to: "/hamster",
    dropdownList: [
      {name: "Them hamster", to: "/newpublish"},
      {name: "Quan ly hamster", to: "/portal"}
    ],
  },
  {
    name: "San pham",
    to: "/product",
    dropdownList: [
      {name: "Them san pham", to: "/newpulish"},
      {name: "Quan ly san pham", to: "/portal"}
    ]
  }
]

const Drawer:React.FC = ()=>{
  return <div>
  <Hidden smDown>
    <div/>
  </Hidden>
  <MenuList>
    {listMenu.map((menuItem)=>(
      (menuItem.dropdownList && Boolean(menuItem.dropdownList)) ? (
      <div>
        <MenuItem >
          {menuItem.name}
        </MenuItem>
        <Collapse>
          <MenuList>
          {menuItem.dropdownList.map((dropDownItem)=>(
            <MenuItem id={menuItem.to+dropDownItem.to} >
              {dropDownItem.name}
            </MenuItem>
          ))}
          </MenuList>
        </Collapse>
      </div>
    ) : (
      <MenuItem id={menuItem.to}>
      {menuItem.name}
      </MenuItem>
    )
  ))}
  </MenuList>
  </div>
};

const NavBar = ()=>{
  
  return(
    <Drawer/>
  );
}

export default NavBar;
