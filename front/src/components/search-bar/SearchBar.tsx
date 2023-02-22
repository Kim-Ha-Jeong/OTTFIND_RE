import { useEffect, useRef, useState } from 'react';
import styled from 'styled-components';

import { useDispatch } from 'react-redux';
import { useSelector } from 'react-redux';

import { RootState } from '@/modules';
import { setCLICK } from '@/modules/setClick';
import { setSEARCH } from '@/modules/setSearch';

const SearchBar = () => {
  const click = useSelector((state: RootState) => state.setClick.click);
  const search = useSelector((state: RootState) => state.setSearch);
  const inputRef = useRef<HTMLDivElement>(null);
  const dispatch = useDispatch();

  const onChangeHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    dispatch(setSEARCH(false, e.target.value));
  };

  const onKeyPressHandler = (e: React.KeyboardEvent<HTMLInputElement>) => {
    if (e.key === 'Enter') dispatch(setSEARCH(true, search.title));
  };

  const onClickHandler = () => {
    click
      ? (dispatch(setCLICK(false)), dispatch(setSEARCH(false, '')))
      : dispatch(setCLICK(true));
  };

  const outSideClickHandler = (e: any) => {
    if (
      inputRef.current === null ||
      (inputRef.current && !inputRef.current.contains(e.currentTarget))
    ) {
      dispatch(setCLICK(false));
      dispatch(setSEARCH(false, ''));
    }
  };

  useEffect(() => {
    if (click) {
      document.addEventListener('click', outSideClickHandler);
    }
    return () => {
      document.removeEventListener('click', outSideClickHandler);
    };
  });
  return (
    <Wrapper ref={inputRef}>
      <Input
        placeholder='영화나 드라마 제목을 입력하세요'
        onChange={onChangeHandler}
        onKeyPress={onKeyPressHandler}
        onClick={onClickHandler}
      ></Input>
    </Wrapper>
  );
};

const Wrapper = styled.div``;

const Input = styled.input`
  background-color: black;
  border: 1px solid rgba(255, 255, 255, 0.2);
  height: 40px;
  width: 650px;
  padding-left: 10px;
  font-size: 15px;
  color: white;
  font-weight: bold;
`;

export default SearchBar;
