const CHANGE = 'change' as const;

export const change = (current: string) => ({
  type: CHANGE,
  current,
});

type payloadState = {
  current: string;
};

type changeAction = ReturnType<typeof change>;

const initialState: payloadState = {
  current: '',
};

const changeBtn = (
  state: payloadState = initialState,
  action: changeAction
) => {
  switch (action.type) {
    case CHANGE:
      return { ...state, current: action.current };
    default:
      return state;
  }
};

export default changeBtn;
